#ifndef RESERVATION_H
#define  RESERVATION_H
#include<QString>
#include <QSqlQueryModel>
#include <QDate>


class reservation
{
public:
   reservation();
  reservation(int id_r,int nbr_pr,int num_tel ,QDate dat);

    int getid_r();
   int getnum_tel();
   int getnbr_pr();
    QDate getdat();
    void setid_r(int);
    void setnum_tel(int);
    void setnbr_pr(int);
    void setdat(QDate);
    bool ajouter();
    QSqlQueryModel* afficher();
     bool supprimer(int);
     bool modifier(int,int,int,QDate);



private:
    int id_r;
   int num_tel;
   int nbr_pr;
    QDate dat;


};

#endif
