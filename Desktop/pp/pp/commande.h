#ifndef COMMANDE_H
#define COMMANDE_H
#include<QString>
#include <QSqlQueryModel>
#include <QDate>

class commande
{
public:
    commande();
    commande(int code,int prix,int cp,int qt,int num_telc,QString nom,QDate datc);

    int getcode();
    int getprix();
    int getcp();
    int getqt();
    int getnum_telc();
    QString getnom();
    QDate getdatc();

    void setcode(int);
    void setprix(int);
    void setcp(int);
    void setqt(int);
    void setnum_telc(int);
    void setnom(QString);
    void setdatc(QDate);

    bool ajouter2();
    QSqlQueryModel* afficher2();
     bool supprimer2(int);
     bool modifier2(int,int,int,int,int,QString,QDate);

     QSqlQueryModel* trier_code();
     QSqlQueryModel* trier_nom();
     QSqlQueryModel* trier_qt();

       QSqlQueryModel* afficher_code(QString);
       bool search_code(QString);

       QSqlQueryModel* afficher_nom(QString);
       bool search_nom(QString);

         QSqlQueryModel* afficher_qt(QString);
         bool search_qt(QString);
//void statistique();

private:

    int code, prix, cp, qt,num_telc;
    QString  nom;
    QDate datc;

};

#endif // COMMANDE_H
