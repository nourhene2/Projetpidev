#ifndef MAINWINDOW_H
#define MAINWINDOW_H
#include "reservation.h"
#include <QMainWindow>
#include<QApplication>
#include"commande.h"

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private slots:



    void on_ajouter1_clicked();

    void on_retour1_clicked();

    void on_modifier1_clicked();

    void on_retour2_clicked();

    void on_pushButton_clicked();

    void on_supprimer1_clicked();

    void on_ajouter2_clicked();

    void on_retour3_clicked();

    void on_pushButton_2_clicked();

    void on_supprimer2_clicked();

    void on_modifier2_clicked();

    void on_radioButton_clicked();

    void on_radioButton_2_clicked();

    void on_radioButton_3_clicked();

    void on_id_r3_textChanged(const QString &arg1);

    void on_id_r2_textChanged(const QString &arg1);

    void on_code2_textChanged(const QString &arg1);

    void on_code3_textChanged(const QString &arg1);

    void on_rechercher_code_clicked();

    void on_rechercher_nom_clicked();

    void on_rechercher_qt_clicked();

    void on_stat_clicked();

    void on_pb_pdf_clicked();

private:
    Ui::MainWindow *ui;
    reservation R;
    commande C;
};
#endif // MAINWINDOW_H
