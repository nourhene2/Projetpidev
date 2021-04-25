#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "reservation.h"
#include <QMessageBox>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_pb_ajout_clicked()
{ /* int id_reservation=ui->le_id->text().toInt();
  int nbr_de_personne=ui->nbr_pr->text().toInt();
  int num_tel_reservation=ui->num_tel->text().toInt();

    Reservation R(id_reservation,nbr_de_personne,num_tel_reservation);*/

    Reservation R(ui->le_id->text().toInt(),ui->num_tel->text().toInt(),ui->nbr_pr->text().toInt());

                   QMessageBox::information(nullptr, QObject::tr("database is open"),
                                QObject::tr("reservation ajoutée:\n"
                     "click ok to exit"),QMessageBox::Ok);


 R.ajouter();


}
