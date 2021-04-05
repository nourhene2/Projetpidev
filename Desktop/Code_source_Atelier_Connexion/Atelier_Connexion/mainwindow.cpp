#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "reservation.h"
#include <QMessageBox>
#include <QIntValidator>
#include "gestion_reservation.h"
#include "gestion_commande.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{

    ui->setupUi(this);

    this->setWindowTitle("RESERVATION");



}
MainWindow::~MainWindow()
{
    delete ui;
}



void MainWindow::on_pushButton_clicked()
{
    gestion_reservation * g1=new gestion_reservation(this);
    g1->show();
}

void MainWindow::on_pushButton_2_clicked()
{
    gestion_commande * g2=new gestion_commande(this);
    g2->show();
}
