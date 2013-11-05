/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.sgcespos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MyRenderer extends DefaultTableCellRenderer {
Color background;
Color foreground;
private static final Font labelFont = new Font("Arial", Font.BOLD, 24);
public MyRenderer (Color background,Color foreground) {
super();
this.background = background;
this.foreground = foreground;
}
@Override
public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
comp.setBackground(background);
comp.setForeground(foreground);
comp.setFont(labelFont);
return comp;
}


}