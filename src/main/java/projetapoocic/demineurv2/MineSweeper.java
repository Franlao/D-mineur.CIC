/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetapoocic.demineurv2;

/**
 *
 * @author francois
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/**MineSweeper by SciWizEH*/
public class MineSweeper extends JFrame implements ActionListener,
        MouseListener {
 
    int rows = 10;
    int cols = 10;
    int numMines = 90;
    GridLayout layout = new GridLayout(rows, cols);
    /*type[][] name = new type[rows][cols];
     * type[x][y];
     * is 1d
     * type[] name = new type[rows*cols];
     * type[(rows*y)+x];*/
    boolean[] mines = new boolean[rows * cols];
    boolean[] clickable = new boolean[rows * cols]; 
    boolean lost = false;
    boolean won = false;
    int[] numbers = new int[rows * cols];
    JButton[] buttons = new JButton[rows * cols];
    boolean[] clickdone = new boolean[rows * cols];
    JMenuItem newGameButton = new JMenuItem("new game");
    JMenuItem difficulty = new JMenuItem("options");
    JLabel mineLabel = new JLabel("mines: " + numMines + " marked: 0");
    JPanel p = new JPanel();
 
    public MineSweeper() {
        p.setLayout(layout);
        setupI();
        for (int i = 0; i < (rows * cols); i++) {
            p.add(buttons[i]);
        }
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("file");
        newGameButton.addActionListener(this);
        m.add(newGameButton);
        difficulty.addActionListener(this);
        m.add(difficulty);
        mb.add(m);
        this.setJMenuBar(mb);
        this.add(p);
        this.add(mineLabel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }
 
    public void fillMines() {
        int needed = numMines;
        while (needed > 0) {
            int x = (int) Math.floor(Math.random() * rows);
            int y = (int) Math.floor(Math.random() * cols);
            if (!mines[(rows * y) + x]) {
                mines[(rows * y) + x] = true;
                needed--;
            }
        }
    }
 
    public void fillNumbers() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                int cur = (rows * y) + x;
                if (mines[cur]) {
                    numbers[cur] = 0;
                    continue;
                }
                int temp = 0;
                boolean l = (x - 1) >= 0;
                boolean r = (x + 1) < rows;
                boolean u = (y - 1) >= 0;
                boolean d = (y + 1) < cols;
                int left = (rows * (y)) + (x - 1);
                int right = (rows * (y)) + (x + 1);
                int up = (rows * (y - 1)) + (x);
                int upleft = (rows * (y - 1)) + (x - 1);
                int upright = (rows * (y - 1)) + (x + 1);
                int down = (rows * (y + 1)) + (x);
                int downleft = (rows * (y + 1)) + (x - 1);
                int downright = (rows * (y + 1)) + (x + 1);
                if (u) {
                    if (mines[up]) {
                        temp++;
                    }
                    if (l) {
                        if (mines[upleft]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (mines[upright]) {
                            temp++;
                        }
                    }
                }
                if (d) {
                    if (mines[down]) {
                        temp++;
                    }
                    if (l) {
                        if (mines[downleft]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (mines[downright]) {
                            temp++;
                        }
                    }
                }
                if (l) {
                    if (mines[left]) {
                        temp++;
                    }
                }
                if (r) {
                    if (mines[right]) {
                        temp++;
                    }
                }
                numbers[cur] = temp;
            }
        }
    }
 
    public void setupI() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                mines[(rows * y) + x] = false;
                clickdone[(rows * y) + x] = false;
                clickable[(rows * y) + x] = true;
                buttons[(rows * y) + x] = new JButton( /*"" + ( x * y )*/);
                buttons[(rows * y) + x].setPreferredSize(new Dimension(
                        45, 45));
                buttons[(rows * y) + x].addActionListener(this);
                buttons[(rows * y) + x].addMouseListener(this);
            }
        }
        fillMines();
        fillNumbers();
    }
 
    public void setupI2() {
        this.remove(p);
        p = new JPanel();
        layout = new GridLayout(rows, cols);
        p.setLayout(layout);
        buttons = new JButton[rows * cols];
        mines = new boolean[rows * cols];
        clickdone = new boolean[rows * cols];
        clickable = new boolean[rows * cols];
        numbers = new int[rows * cols];
        setupI();
        for (int i = 0; i < (rows * cols); i++) {
            p.add(buttons[i]);
        }
        this.add(p);
        this.pack();
        fillMines();
        fillNumbers();
    }
 
    public void setup() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                mines[(rows * y) + x] = false;
                clickdone[(rows * y) + x] = false;
                clickable[(rows * y) + x] = true;
                buttons[(rows * y) + x].setEnabled(true);
                buttons[(rows * y) + x].setText("");
            }
        }
        fillMines();
        fillNumbers();
        lost = false;
        mineLabel.setText("mines: " + numMines + " marked: 0");
    }
 
    public static void main(String[] args) {
        new MineSweeper();
    }
 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == difficulty) {
            rows = Integer.parseInt((String) JOptionPane.showInputDialog(
                    this, "Rows", "Rows", JOptionPane.PLAIN_MESSAGE, null,
                    null, 10));
            cols = Integer.parseInt((String) JOptionPane.showInputDialog(
                    this, "Columns", "Columns", JOptionPane.PLAIN_MESSAGE,
                    null, null, 10));
            numMines = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Mines", "Mines",
                    JOptionPane.PLAIN_MESSAGE, null, null, 10));
            setupI2();
        }
        if (!won) {
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (e.getSource() == buttons[(rows * y) + x]
                            && !won && clickable[(rows * y) + x]) {
                        doCheck(x, y);
                        break;
                    }
                }
            }
        }
        if (e.getSource() == newGameButton) {
            setup();
            won = false;
            return;
 
        }
        checkWin();
    }
 
    public void mouseEntered(MouseEvent e) {
    }
 
    public void mouseExited(MouseEvent e) {
    }
 
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3) {
            int n = 0;
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (e.getSource() == buttons[(rows * y) + x]) {
                        clickable[(rows * y) + x] = !clickable[(rows * y)
                                + x];
                    }
                    if (!clickdone[(rows * y) + x]) {
                        if (!clickable[(rows * y) + x]) {
                            buttons[(rows * y) + x].setText("X");
                            n++;
                        } else {
                            buttons[(rows * y) + x].setText("");
                        }
                        mineLabel.setText("mines: " + numMines + " marked: "
                                + n);
                    }
                }
            }
        }
    }
 
    public void mouseReleased(MouseEvent e) {
    }
 
    public void mouseClicked(MouseEvent e) {
    }
 
    public void doCheck(int x, int y) {
        int cur = (rows * y) + x;
        boolean l = (x - 1) >= 0;
        boolean r = (x + 1) < rows;
        boolean u = (y - 1) >= 0;
        boolean d = (y + 1) < cols;
        int left = (rows * (y)) + (x - 1);
        int right = (rows * (y)) + (x + 1);
        int up = (rows * (y - 1)) + (x);
        int upleft = (rows * (y - 1)) + (x - 1);
        int upright = (rows * (y - 1)) + (x + 1);
        int down = (rows * (y + 1)) + (x);
        int downleft = (rows * (y + 1)) + (x - 1);
        int downright = (rows * (y + 1)) + (x + 1);
 
        clickdone[cur] = true;
        buttons[cur].setEnabled(false);
        if (numbers[cur] == 0 && !mines[cur] && !lost && !won) {
            if (u && !won) {
                if (!clickdone[up] && !mines[up]) {
                    clickdone[up] = true;
                    buttons[up].doClick();
                }
                if (l && !won) {
                    if (!clickdone[upleft] && numbers[upleft] != 0
                            && !mines[upleft]) {
                        clickdone[upleft] = true;
                        buttons[upleft].doClick();
                    }
                }
                if (r && !won) {
                    if (!clickdone[upright] && numbers[upright] != 0
                            && !mines[upright]) {
                        clickdone[upright] = true;
                        buttons[upright].doClick();
                    }
                }
            }
            if (d && !won) {
                if (!clickdone[down] && !mines[down]) {
                    clickdone[down] = true;
                    buttons[down].doClick();
                }
                if (l && !won) {
                    if (!clickdone[downleft] && numbers[downleft] != 0
                            && !mines[downleft]) {
                        clickdone[downleft] = true;
                        buttons[downleft].doClick();
                    }
                }
                if (r && !won) {
                    if (!clickdone[downright]
                            && numbers[downright] != 0
                            && !mines[downright]) {
                        clickdone[downright] = true;
                        buttons[downright].doClick();
                    }
                }
            }
            if (l && !won) {
                if (!clickdone[left] && !mines[left]) {
                    clickdone[left] = true;
                    buttons[left].doClick();
                }
            }
            if (r && !won) {
                if (!clickdone[right] && !mines[right]) {
                    clickdone[right] = true;
                    buttons[right].doClick();
                }
            }
        } else {
            buttons[cur].setText("" + numbers[cur]);
            if (!mines[cur] && numbers[cur] == 0) {
                buttons[cur].setText("");
            }
        }
        if (mines[cur] && !won) {
            buttons[cur].setText("0");
            doLose();
        }
    }
 
    public void checkWin() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                int cur = (rows * y) + x;
                if (!clickdone[cur]) {
                    if (mines[cur]) {
                        continue;
                    } else {
                        return;
                    }
                }
            }
        }
 
        doWin();
    }
 
    public void doWin() {
        if (!lost && !won) {
            won = true;
            JOptionPane.showMessageDialog(null,
                    "you win!nstarting a new game", "you lose",
                    JOptionPane.INFORMATION_MESSAGE);
            newGameButton.doClick();
        }
    }
 
    public void doLose() {
        if (!lost && !won) {
            lost = true;
            for (int i = 0; i < rows * cols; i++) {
                if (!clickdone[i]) {
                    buttons[i].doClick(0);
                }
            }
            JOptionPane.showMessageDialog(null,
                    "you lose!nstarting a new game", "you lose",
                    JOptionPane.ERROR_MESSAGE);
            setup();
        }
    }
}
