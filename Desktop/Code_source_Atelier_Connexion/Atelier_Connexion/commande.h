#ifndef COMMANDE_H
#define COMMANDE_H
#include <QDate>
#include <QSqlQueryModel>
#include <QString>
#include <QSqlQuery>

class Commande
{
public:
    Commande();
     Commande(int code,int prix ,int adr ,int qt ,int num_telc,QString nom , QDate datc);
     int getcode();
     int getprix();
      int getadr();
       int getqt();
       int getnum_telc();
     QString getnom();
      QDate getdatc();


     void setcode(int);
     void setprix (int);
     void setadr (int);
      void setqt (int);
     void setnum_telc(int);
      void setnom (QString);
     void setdatc(QDate);
     bool ajouter();
    QSqlQueryModel* afficher_c();
     bool supprimer_c(int);
     bool modifier_co(int,int,int,int,int,QString,QDate);




private:
     int code;
     int prix;
      int adr;
       int qt;
       int num_telc;
    QString nom;
    QDate datc;


};

#endif // RESERVATION_H
