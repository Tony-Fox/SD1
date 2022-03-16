package gui;

import com.mysql.cj.util.StringUtils;
import controller.DestinationController;
import controller.VacationController;
import entity.Destination;
import entity.Vacation;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainWindow {
    private JPanel mainPanel;
    private JTable destinationTable;
    private JButton addDestinationButton;
    private JButton editDestinationButton;
    private JButton deleteDestinationButton;
    private JTabbedPane tabbedPane1;
    private JButton addVacationButton;
    private JButton editVacationButton;
    private JButton deleteVacationButton;
    private JTextField destinationIdTextField;
    private JTextField destinationNameTextField;
    private JTextField vacationIdTextField;
    private JTextField vacationNameTextField;
    private JTextField vacationPriceTextField;
    private JTextField vacationPeriodTextField;
    private JTextField vacationExtraDetailsTextField;
    private JTextField vacationMaxPeopleTextField;
    private JTextField vacationDestinationIdTextField;
    private JTable vacationTable;
    DestinationController destinationController;
    VacationController vacationController;
    List<Destination> destinations;
    List<Vacation> vacations;

    public MainWindow() {
        destinationController = new DestinationController();
        vacationController = new VacationController();
    }

    void refreshData() {
        destinations = destinationController.getDestinations();
        vacations = vacationController.getVacations();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createError(String s) {
        JOptionPane.showMessageDialog(new JFrame(), s, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void createUIComponents() {
            DestinationController destinationController = new DestinationController();
            VacationController vacationController = new VacationController();

            destinations = destinationController.getDestinations();
            vacations = vacationController.getVacations();

            String[] destinationColumns = {"ID", "Name"};
            String[] vacationColumns = {"ID", "Name", "Price", "Period", "Details", "Max People", "Destination ID"};

            class DestinationTableModel extends AbstractTableModel{

                @Override
                public String getColumnName(int i) {
                    return destinationColumns[i];
                }

                @Override
                public int getRowCount() {
                    return destinations.size();
                }

                @Override
                public int getColumnCount() {
                    return destinationColumns.length;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    if(columnIndex == 0)
                        return destinations.get(rowIndex).getDestination_id();
                    if (columnIndex == 1)
                        return destinations.get(rowIndex).getDestinationName();
                    return null;
                }
            }

            class VacationTableModel extends AbstractTableModel{

                @Override
                public String getColumnName(int i) {
                    return vacationColumns[i];
                }

                @Override
                public int getRowCount() {
                    return vacations.size();
                }

                @Override
                public int getColumnCount() {
                    return vacationColumns.length;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    if (columnIndex == 0)
                        return vacations.get(rowIndex).getVacation_id();
                    if (columnIndex == 1)
                        return vacations.get(rowIndex).getName();
                    if (columnIndex == 2)
                        return vacations.get(rowIndex).getPrice();
                    if (columnIndex == 3)
                        return vacations.get(rowIndex).getPeriod();
                    if (columnIndex == 4)
                        return vacations.get(rowIndex).getExtra_details();
                    if (columnIndex == 5)
                        return vacations.get(rowIndex).getMax_people();
                    if (columnIndex == 6)
                        return vacations.get(rowIndex).getDestination().getDestination_id();
                    return null;
                }
            }

            destinationTable = new JTable(new DestinationTableModel());
            vacationTable = new JTable(new VacationTableModel());


            addDestinationButton = new JButton();
            addDestinationButton.setEnabled(true);
            editDestinationButton = new JButton();
            editDestinationButton.setEnabled(true);
            deleteDestinationButton = new JButton();
            deleteDestinationButton.setEnabled(true);

            addVacationButton = new JButton();
            addVacationButton.setEnabled(true);
            editVacationButton = new JButton();
            editVacationButton.setEnabled(true);
            deleteVacationButton = new JButton();
            deleteVacationButton.setEnabled(true);

            addDestinationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (destinationIdTextField.getText().isEmpty() || destinationNameTextField.getText().isEmpty())
                        createError("Text boxes can't be empty!");
                    else if (!StringUtils.isStrictlyNumeric(destinationIdTextField.getText()))
                        createError("ID has to be a positive integer!");
                    else {
                        destinationController.CreateDestination(Integer.parseInt(destinationIdTextField.getText()), destinationNameTextField.getText());
                        refreshData();
                        destinationTable.repaint();
                    }
                }
            });

            editDestinationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (destinationNameTextField.getText().isEmpty())
                        createError("Name text box can't be empty!");
//                    else if (!StringUtils.isStrictlyNumeric(destinationIdTextField.getText()))
//                        createError("ID has to be a positive integer!");
                    else if(destinationTable.getSelectedRow() != -1) {
                        destinationController.updateDestinationById((Integer) destinationTable.getModel().getValueAt(destinationTable.getSelectedRow(), 0),
                                (Integer) destinationTable.getModel().getValueAt(destinationTable.getSelectedRow(), 0),
                                destinationNameTextField.getText());
                        refreshData();
                        destinationTable.repaint();
                    }
                }
            });

            deleteDestinationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (destinationTable.getSelectedRow() != -1) {
                        vacationController.deleteVacationsByDestinationId((Integer) destinationTable.getModel().getValueAt(destinationTable.getSelectedRow(), 0));
                        destinationController.deleteDestinationById((Integer) destinationTable.getModel().getValueAt(destinationTable.getSelectedRow(), 0));
                        refreshData();
                        destinationTable.repaint();
                    }
                }
            });

        addVacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vacationIdTextField.getText().isEmpty() ||
                        vacationNameTextField.getText().isEmpty() ||
                        vacationPriceTextField.getText().isEmpty() ||
                        vacationPeriodTextField.getText().isEmpty() ||
                        vacationExtraDetailsTextField.getText().isEmpty() ||
                        vacationMaxPeopleTextField.getText().isEmpty() ||
                        vacationDestinationIdTextField.getText().isEmpty())
                    createError("Text boxes can't be empty!");
                else if (!StringUtils.isStrictlyNumeric(vacationIdTextField.getText()) ||
                        !StringUtils.isStrictlyNumeric(vacationPriceTextField.getText()) ||
                        !StringUtils.isStrictlyNumeric(vacationPeriodTextField.getText()) ||
                        !StringUtils.isStrictlyNumeric(vacationMaxPeopleTextField.getText()) ||
                        !StringUtils.isStrictlyNumeric(vacationDestinationIdTextField.getText()))
                    createError("Some fields are numeric only!");
                else {
                    vacationController.createVacation(
                            Integer.parseInt(vacationIdTextField.getText()),
                            vacationNameTextField.getText(),
                            Integer.parseInt(vacationPriceTextField.getText()),
                            Integer.parseInt(vacationPeriodTextField.getText()),
                            vacationExtraDetailsTextField.getText(),
                            Integer.parseInt(vacationMaxPeopleTextField.getText()),
                            destinationController.getDestinationById(Integer.parseInt(vacationDestinationIdTextField.getText())));
                    refreshData();
                    vacationTable.repaint();
                }
            }
        });

        editVacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vacationNameTextField.getText().isEmpty() ||
                        vacationPriceTextField.getText().isEmpty() ||
                        vacationPeriodTextField.getText().isEmpty() ||
                        vacationExtraDetailsTextField.getText().isEmpty() ||
                        vacationMaxPeopleTextField.getText().isEmpty())
                    createError("Text boxes can't be empty!");
                else if (!StringUtils.isStrictlyNumeric(vacationPriceTextField.getText()) ||
                        !StringUtils.isStrictlyNumeric(vacationPeriodTextField.getText()) ||
                        !StringUtils.isStrictlyNumeric(vacationMaxPeopleTextField.getText()))
                    createError("Some fields are numeric only!");
                else if(vacationTable.getSelectedRow() != -1) {
                    vacationController.updateVacationById(
                            (Integer) vacationTable.getModel().getValueAt(vacationTable.getSelectedRow(), 0),
                            vacationNameTextField.getText(),
                            Integer.parseInt(vacationPriceTextField.getText()),
                            Integer.parseInt(vacationPeriodTextField.getText()),
                            vacationExtraDetailsTextField.getText(),
                            Integer.parseInt(vacationMaxPeopleTextField.getText())
                            );
                    refreshData();
                    vacationTable.repaint();
                }
            }
        });


        deleteVacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vacationTable.getSelectedRow() != -1) {
                    vacationController.deleteVacationById((Integer) vacationTable.getModel().getValueAt(vacationTable.getSelectedRow(), 0));
                    refreshData();
                    vacationTable.repaint();
                }
            }
        });

        }

}
