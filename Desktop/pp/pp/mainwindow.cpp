#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "reservation.h"
#include<QMessageBox>
#include"QApplication"
#include<QIntValidator>
#include"commande.h"
#include  <QSqlQuery>
/*#include<QtCharts>
#include<QPieSeries>
#include<QPieSlice>*/
#include <QPainter>
#include <QPdfWriter>
#include <QDesktopServices>
#include <QUrl>
#include <QPixmap>


MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    ui->stackedWidget->setCurrentIndex(0);
    ui->tab_r->setModel(R.afficher());
     ui->tab_c->setModel(C.afficher2());
     ui->code->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
     ui->prix->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
     ui->cp->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
     ui->qt->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->num_telc->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->nom->setValidator(new QRegExpValidator(QRegExp("[A-Za-z]+")));
         ui->code2->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->num_telc3->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->nom3->setValidator(new QRegExpValidator(QRegExp("[A-Za-z]+")));
         ui->code3->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->cp3->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->qt3->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->prix3->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->id_r->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->nbr_pr->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->num_tel->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->id_r3->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->id_r2->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->nbr_pr2->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));
         ui->num_tel2->setValidator(new QRegExpValidator(QRegExp("[0-9]{8}")));





}

MainWindow::~MainWindow()
{
    delete ui;
}




void MainWindow::on_ajouter1_clicked()
{
    reservation R(ui->id_r->text().toInt(),ui->num_tel->text().toInt(),ui->nbr_pr->text().toInt(),ui->dat->date());
           int id_r= ui->id_r->text().toInt();
            int nbr_pr= ui->nbr_pr->text().toInt();
             int num_tel= ui->num_tel->text().toInt();
        bool test=R.ajouter();
             if(id_r==0||num_tel==0||nbr_pr==0)
             {
                QMessageBox::critical(nullptr, QObject::tr("vide"),
                                                 QObject::tr("veuillez saisir tous les champs correctement!\n"), QMessageBox::Cancel);

             }

               else if(test==true){
                QMessageBox::information(nullptr, QObject::tr("database is open"),
                                QObject::tr("reservation ajoutée:\n"
                     "click ok to exit"),QMessageBox::Ok);
                ui->tab_r->setModel(R.afficher());}
             else{QMessageBox::information(nullptr, QObject::tr("database is open"),
                                           QObject::tr("reservation existe deja:\n"
                                "click ok to exit"),QMessageBox::Ok);}

                 R.ajouter();
}

void MainWindow::on_retour1_clicked()
{
      ui->stackedWidget->setCurrentIndex(0);
}

void MainWindow::on_modifier1_clicked()
{
    reservation R2;
          R2.setid_r(ui->id_r2->text().toInt());
          R2.setnum_tel(ui->num_tel2->text().toInt());
          R2.setnbr_pr(ui->nbr_pr2->text().toInt());
          R2.setdat(ui->dat2->date());

           R2.modifier(R2.getid_r(),R2.getnum_tel(),R2.getnbr_pr(),R2.getdat());
           int id_r= ui->id_r2->text().toInt();
           int num_tel=ui->num_tel2->text().toInt();
            int nbr_pr=ui->nbr_pr2->text().toInt();
           if(id_r==0||num_tel==0||nbr_pr==0)
                {
                   QMessageBox::critical(nullptr, QObject::tr("vide"),
                                                    QObject::tr("veuillez saisir tous les champs correctement!\n"), QMessageBox::Cancel);

                }

           else {
               QMessageBox::information(nullptr, QObject::tr("database is open"),
                       QObject::tr("reservation modifiee:\n"
            "click ok to exit"),QMessageBox::Ok);
               ui->tab_r->setModel(R.afficher());
    }

}

void MainWindow::on_retour2_clicked()
{
    ui->stackedWidget->setCurrentIndex(0);
}

void MainWindow::on_pushButton_clicked()
{
    ui->stackedWidget->setCurrentIndex(1);
}

void MainWindow::on_supprimer1_clicked()
{
    reservation R1;
      R1.setid_r(ui->id_r3->text().toInt());
      bool test=R1.supprimer(R1.getid_r());
      QMessageBox msgBox;
      if(test)
         { msgBox.setText("suppression avec succes");
       ui->tab_r->setModel(R.afficher());
      }
      else
          msgBox.setText("echec de la suppression");
      msgBox.exec();

}

void MainWindow::on_ajouter2_clicked()
{
    commande C(ui->code->text().toInt(),ui->prix->text().toInt(),ui->cp->text().toInt(),ui->qt->text().toInt(),ui->num_telc->text().toInt(),ui->nom->text(),ui->datc->date());
           int code= ui->code->text().toInt();
            int prix= ui->prix->text().toInt();
             int cp= ui->cp->text().toInt();
             int qt= ui->qt->text().toInt();
             int num_telc= ui->num_telc->text().toInt();
             QString nom= ui->nom->text();

        bool test=C.ajouter2();
             if(code==0||prix==0||cp==0||qt==0||num_telc==0||nom=="")
             {
                QMessageBox::critical(nullptr, QObject::tr("vide"),
                                                 QObject::tr("veuillez saisir tous les champs correctement!\n"), QMessageBox::Cancel);

             }

               else if(test==true){
                QMessageBox::information(nullptr, QObject::tr("database is open"),
                                QObject::tr("commande ajoutée:\n"
                     "click ok to exit"),QMessageBox::Ok);
                ui->tab_c->setModel(C.afficher2());}
             else{QMessageBox::information(nullptr, QObject::tr("database is open"),
                                           QObject::tr("commande existe deja:\n"
                                "click ok to exit"),QMessageBox::Ok);}

                 C.ajouter2();
}

void MainWindow::on_retour3_clicked()
{
     ui->stackedWidget->setCurrentIndex(0);
}

void MainWindow::on_pushButton_2_clicked()
{
     ui->stackedWidget->setCurrentIndex(2);
}

void MainWindow::on_supprimer2_clicked()
{
    commande C1;
      C1.setcode(ui->code2->text().toInt());
      bool test=C1.supprimer2(C1.getcode());
      QMessageBox msgBox;
      if(test)
         { msgBox.setText("suppression avec succes");
       ui->tab_c->setModel(C.afficher2());
      }
      else
          msgBox.setText("echec de la suppression");
      msgBox.exec();
}

void MainWindow::on_modifier2_clicked()
{
    commande C2;
          C2.setcode(ui->code3->text().toInt());
          C2.setprix(ui->prix3->text().toInt());
          C2.setcp(ui->cp3->text().toInt());
          C2.setqt(ui->qt3->text().toInt());
          C2.setnum_telc(ui->num_telc3->text().toInt());
          C2.setnom(ui->nom3->text());
          C2.setdatc(ui->datc3->date());

           C2.modifier2(C2.getcode(),C2.getprix(),C2.getcp(),C2.getqt(),C2.getnum_telc(),C2.getnom(),C2.getdatc());
           int code= ui->code->text().toInt();
            int prix= ui->prix->text().toInt();
             int cp= ui->cp->text().toInt();
             int qt= ui->qt->text().toInt();
             int num_telc= ui->num_telc->text().toInt();
             QString nom= ui->nom->text();
           if(code==0||prix==0||cp==0||qt==0||num_telc==0||nom=="")
                {
                   QMessageBox::critical(nullptr, QObject::tr("vide"),
                                                    QObject::tr("veuillez saisir tous les champs correctement!\n"), QMessageBox::Cancel);

                }

           else {
               QMessageBox::information(nullptr, QObject::tr("database is open"),
                       QObject::tr("commande modifiee:\n"
            "click ok to exit"),QMessageBox::Ok);
               ui->tab_c->setModel(C.afficher2());
    }
}

void MainWindow::on_radioButton_clicked()
{
    ui->tab_c->setModel( C.trier_code());

}

void MainWindow::on_radioButton_2_clicked()
{
    ui->tab_c->setModel( C.trier_nom());
}

void MainWindow::on_radioButton_3_clicked()
{
    ui->tab_c->setModel( C.trier_qt());
}

void MainWindow::on_id_r3_textChanged(const QString &arg1)
{
    QSqlQueryModel *model= new QSqlQueryModel();
            QSqlQuery   *query= new QSqlQuery();
            query->prepare("SELECT * FROM reservation  WHERE ID_R  LIKE'"+arg1+"%' or NBR_PR  LIKE'"+arg1+"%' or NUM_TEL LIKE'"+arg1+"%'or DAT LIKE'"+arg1+"%' ");
             query->exec();
             if (query->next()) { }
             else {
                 QMessageBox::critical(nullptr, QObject::tr("SEARCH"),
                                 QObject::tr("NO MATCH FOUND !.\n"
                                             "Click Cancel to exit."), QMessageBox::Cancel);
                 ui->id_r3->clear();}
}

void MainWindow::on_id_r2_textChanged(const QString &arg1)
{
    QSqlQueryModel *model= new QSqlQueryModel();
            QSqlQuery   *query= new QSqlQuery();
            query->prepare("SELECT * FROM reservation  WHERE ID_R  LIKE'"+arg1+"%' or NBR_PR  LIKE'"+arg1+"%' or NUM_TEL LIKE'"+arg1+"%' or DAT'"+arg1+"%' ");
             query->exec();
             if (query->next()) { }
             else {
                 QMessageBox::critical(nullptr, QObject::tr("SEARCH"),
                                 QObject::tr("NO MATCH FOUND !.\n"
                                             "Click Cancel to exit."), QMessageBox::Cancel);
                 ui->id_r2->clear();}
}


void MainWindow::on_code2_textChanged(const QString &arg1)
{
    QSqlQueryModel *model= new QSqlQueryModel();
            QSqlQuery   *query= new QSqlQuery();
            query->prepare("SELECT * FROM commande  WHERE CODE LIKE'"+arg1+"%' or PRIX  LIKE'"+arg1+"%' or CP LIKE'"+arg1+"%'or QT'"+arg1+"%'or NUM_TELC LIKE'"+arg1+"%'or NOM LIKE'"+arg1+"%'or DATC LIKE'"+arg1+"%' ");
             query->exec();
             if (query->next()) { }
             else {
                 QMessageBox::critical(nullptr, QObject::tr("SEARCH"),
                                 QObject::tr("NO MATCH FOUND !.\n"
                                             "Click Cancel to exit."), QMessageBox::Cancel);
                 ui->code2->clear();}
}

void MainWindow::on_code3_textChanged(const QString &arg1)
{
    QSqlQueryModel *model= new QSqlQueryModel();
            QSqlQuery   *query= new QSqlQuery();
            query->prepare("SELECT * FROM commande  WHERE CODE LIKE'"+arg1+"%' or PRIX  LIKE'"+arg1+"%' or CP LIKE'"+arg1+"%'or QT'"+arg1+"%'or NUM_TELC LIKE'"+arg1+"%'or NOM LIKE'"+arg1+"%'or DATC LIKE'"+arg1+"%' ");
             query->exec();
             if (query->next()) { }
             else {
                 QMessageBox::critical(nullptr, QObject::tr("SEARCH"),
                                 QObject::tr("NO MATCH FOUND !.\n"
                                             "Click Cancel to exit."), QMessageBox::Cancel);
                 ui->code3->clear();}
}

void MainWindow::on_rechercher_code_clicked()
{
    QString code = ui->recher_code->text();
    ui->tab_c->setModel(C.afficher_code(code));
}


void MainWindow::on_rechercher_nom_clicked()
{
    QString nom = ui->recher_nom->text();
     ui->tab_c->setModel(C.afficher_nom(nom));
}

void MainWindow::on_rechercher_qt_clicked()
{
    QString qt = ui->recher_qt->text();
     ui->tab_c->setModel(C.afficher_qt(qt));
}


/*void MainWindow::on_stat_clicked()
{

     QPieSeries *series = new QPieSeries();
        QChart *chart = new QChart();

    QSqlQuery query;
    QPieSlice *slice;
    int id=0;
    query.prepare("SELECT* FROM commande ");
    if(query.exec())
    {int i=0;
    while(query.next())
    {

       series->append(query.value(1).toString(), query.value(0).toInt());
    slice = series->slices().at(i);
       slice->setExploded();
        slice->setLabelVisible();
        slice->setPen(QPen(Qt::darkGreen, 2));

        slice->setBrush(Qt::green);
        i++;

    }}

    //![1]

    //![2]

       slice1->setExploded();
         slice1->setLabelVisible();
         slice1->setPen(QPen(Qt::darkGreen, 2));
         slice1->setBrush(Qt::green);
    //![2]

    //![3]
        chart->addSeries(series);
        chart->setTitle("Statisque : nombre d'employés par département");



    QChartView *chartView = new QChartView(chart);
            chartView->setRenderHint(QPainter::Antialiasing);
                         chartView->show();



}
*/

void MainWindow::on_pb_pdf_clicked()
{
    QPdfWriter pdf("C:/Users/User/Desktop/pp/pp/Pdfreservation.pdf");
                          QPainter painter(&pdf);
                         int i = 4000;
                              painter.setPen(Qt::red);
                              painter.setFont(QFont("Arial", 30));
                              painter.drawText(2300,1200,"Liste Des Reservations");
                              painter.setPen(Qt::black);
                              painter.setFont(QFont("Arial", 50));
                             // painter.drawText(1100,2000,afficheDC);
                              painter.drawRect(1500,200,7300,2600);
                              painter.drawPixmap(QRect(7600,70,2000,2600),QPixmap("C:/Users/User/Downloads/150123410_1102641506814079_4892972152459660250_n (1).png"));
                              painter.drawRect(0,3000,9600,500);
                              painter.setFont(QFont("Arial", 9));
                              painter.drawText(300,3300,"ID_R");
                              painter.drawText(2300,3300,"NBR_PR");
                              painter.drawText(4300,3300,"NUM_TEL");
                              painter.drawText(6300,3300,"DAT");




                              QSqlQuery query;
                              query.prepare("select * from RESERVATION");
                              query.exec();
                              while (query.next())
                              {
                                  painter.drawText(300,i,query.value(0).toString());
                                  painter.drawText(2300,i,query.value(1).toString());
                                  painter.drawText(4300,i,query.value(2).toString());
                                  painter.drawText(6300,i,query.value(3).toString());



                                 i = i +500;
                              }
                              int reponse = QMessageBox::question(this, "Génerer PDF", "<PDF Enregistré>...Vous Voulez Affichez Le PDF ?", QMessageBox::Yes |  QMessageBox::No);
                                  if (reponse == QMessageBox::Yes)
                                  {
                                      QDesktopServices::openUrl(QUrl::fromLocalFile("C:/Users/User/Desktop/pp/pp/Pdfreservation.pdf"));

                                      painter.end();
                                  }
                                  if (reponse == QMessageBox::No)
                                  {
                                       painter.end();
                                  }
}
