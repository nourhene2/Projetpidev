#include "commande.h"
#include  <QSqlQuery>
#include <QtDebug>
#include<QObject>
/*#include<QtCharts>
#include<QPieSeries>
#include<QPieSlice>*/

int commande:: getcode(){return code;}
int commande::getprix(){return prix;}
int commande::getcp(){return cp;}
int commande:: getqt(){return qt;}
int commande:: getnum_telc(){return num_telc;}
QString commande::getnom(){return nom;}
QDate commande:: getdatc(){return datc;}

void commande:: setcode(int code){this->code=code;}
void commande:: setprix(int prix){this->prix=prix;}
void commande::setcp(int cp){this->cp=cp;}
void commande ::setqt(int qt) {this->qt=qt;}
void commande::setnum_telc(int num_telc){this->num_telc=num_telc;}
void commande::setnom(QString nom){this->nom=nom;}
void commande::setdatc(QDate datc){this->datc=datc;}


commande::commande()
{}
commande::commande(int code,int prix,int cp,int qt,int num_telc,QString nom,QDate datc)
{
   this->code=code;
 this->prix=prix;
 this->cp=cp;
 this->qt=qt;
 this->num_telc=num_telc;
 this->nom=nom;
 this->datc=datc;


}
bool commande::ajouter2()
{
    QSqlQuery query;

         query.prepare("INSERT INTO commande ( CODE, PRIX,CP,QT,NUM_TELC,NOM,DATC) "
                       "VALUES ( :code, :prix, :cp, :qt, :num_telc, :nom, :datc)");
         query.bindValue(":code", code);
         query.bindValue(":prix", prix);
         query.bindValue(":cp", cp);
         query.bindValue(":qt", qt);
         query.bindValue(":num_telc", num_telc);
         query.bindValue(":nom", nom);
         query.bindValue(":datc", datc);


    return query.exec();
}
bool commande::supprimer2(int code)
{
     QSqlQuery query;
    query.prepare("Delete from commande where code=:code");
    query.bindValue(":code", code);

   return query.exec();
}
QSqlQueryModel* commande::afficher2()
{
    QSqlQueryModel* model=new QSqlQueryModel();

          model->setQuery("SELECT* FROM commande");
          model->setHeaderData(0, Qt::Horizontal, QObject::tr("code"));
          model->setHeaderData(1, Qt::Horizontal, QObject::tr("prix"));
          model->setHeaderData(2, Qt::Horizontal, QObject::tr("cp"));
          model->setHeaderData(3, Qt::Horizontal, QObject::tr("qt"));
          model->setHeaderData(4, Qt::Horizontal, QObject::tr("num_telc"));
          model->setHeaderData(5, Qt::Horizontal, QObject::tr("nom"));
          model->setHeaderData(6, Qt::Horizontal, QObject::tr("datc"));

    return model;
}
bool commande::modifier2(int code,int prix,int cp,int qt,int num_telc,QString nom ,QDate datc)
{

    QSqlQuery query;
    query.prepare("UPDATE commande set code=:code, prix=:prix, cp=:cp , qt=:qt , num_telc=:num_telc , nom=:nom , datc=:datc  WHERE code=:code");
    query.bindValue(":code", code);
    query.bindValue(":prix", prix);
    query.bindValue(":cp", cp);
    query.bindValue(":qt", qt);
    query.bindValue(":num_telc", num_telc);
    query.bindValue(":nom", nom);
    query.bindValue(":datc", datc);

    return query.exec();
}
QSqlQueryModel* commande::trier_code()
{
    QSqlQueryModel* model = new QSqlQueryModel();
        model->setQuery("SELECT * from commande ORDER BY code");

        model->setHeaderData(0, Qt::Horizontal, QObject::tr("code"));
        model->setHeaderData(1, Qt::Horizontal, QObject::tr("prix"));
        model->setHeaderData(2, Qt::Horizontal, QObject::tr("cp"));
        model->setHeaderData(3, Qt::Horizontal, QObject::tr("qt"));
        model->setHeaderData(4, Qt::Horizontal, QObject::tr("num_telc"));
        model->setHeaderData(5, Qt::Horizontal, QObject::tr("nom"));
        model->setHeaderData(6, Qt::Horizontal, QObject::tr("datc"));

        return model ;
}

QSqlQueryModel* commande::trier_nom()
{
    QSqlQueryModel* model = new QSqlQueryModel();
        model->setQuery("SELECT * from commande ORDER BY nom");

        model->setHeaderData(0, Qt::Horizontal, QObject::tr("code"));
        model->setHeaderData(1, Qt::Horizontal, QObject::tr("prix"));
        model->setHeaderData(2, Qt::Horizontal, QObject::tr("cp"));
        model->setHeaderData(3, Qt::Horizontal, QObject::tr("qt"));
        model->setHeaderData(4, Qt::Horizontal, QObject::tr("num_telc"));
        model->setHeaderData(5, Qt::Horizontal, QObject::tr("nom"));
        model->setHeaderData(6, Qt::Horizontal, QObject::tr("datc"));

        return model ;
}

QSqlQueryModel* commande::trier_qt()
{
    QSqlQueryModel* model = new QSqlQueryModel();
        model->setQuery("SELECT * from commande ORDER BY qt");

        model->setHeaderData(0, Qt::Horizontal, QObject::tr("code"));
        model->setHeaderData(1, Qt::Horizontal, QObject::tr("prix"));
        model->setHeaderData(2, Qt::Horizontal, QObject::tr("cp"));
        model->setHeaderData(3, Qt::Horizontal, QObject::tr("qt"));
        model->setHeaderData(4, Qt::Horizontal, QObject::tr("num_telc"));
        model->setHeaderData(5, Qt::Horizontal, QObject::tr("nom"));
        model->setHeaderData(6, Qt::Horizontal, QObject::tr("datc"));

        return model ;
}
QSqlQueryModel* commande::afficher_code(QString code)
{
    QSqlQuery query;
    query.prepare("SELECT * FROM COMMANDE WHERE CODE=:code ");
    query.bindValue(":code", code);
    QSqlQueryModel* model= new QSqlQueryModel();
    query.exec();
    model->setQuery(query);
    model->setHeaderData(0, Qt::Horizontal, QObject::tr("code"));
    model->setHeaderData(1, Qt::Horizontal, QObject::tr("prix"));
    model->setHeaderData(2, Qt::Horizontal, QObject::tr("cp"));
    model->setHeaderData(3, Qt::Horizontal, QObject::tr("qt"));
    model->setHeaderData(4, Qt::Horizontal, QObject::tr("num_telc"));
    model->setHeaderData(5, Qt::Horizontal, QObject::tr("nom"));
    model->setHeaderData(6, Qt::Horizontal, QObject::tr("datc"));
    return model;
}

bool commande::search_code(QString code)
{
    QSqlQuery query;
    query.prepare("SELECT NOM FROM COMMANDE WHERE NOM=:nom");
    query.bindValue(":code",code);
    query.exec();

    if(query.size()!=code){return false;}
    else return true;
}





// recherhe par nom
QSqlQueryModel* commande::afficher_nom(QString nom)
{
    QSqlQuery query;
    query.prepare("SELECT * FROM COMMANDE WHERE NOM=:nom ");
    query.bindValue(":nom", nom);
    QSqlQueryModel* model= new QSqlQueryModel();
    query.exec();
    model->setQuery(query);
    model->setHeaderData(0, Qt::Horizontal, QObject::tr("CODE"));
    model->setHeaderData(1, Qt::Horizontal, QObject::tr("PRIX"));
    model->setHeaderData(2, Qt::Horizontal, QObject::tr("CP"));
    model->setHeaderData(3, Qt::Horizontal, QObject::tr("QT"));
    model->setHeaderData(4, Qt::Horizontal, QObject::tr("NUM_TELC"));
     model->setHeaderData(5, Qt::Horizontal, QObject::tr("NOM"));;
     model->setHeaderData(6, Qt::Horizontal, QObject::tr("DATC"));

    return model;
}

bool commande::search_nom(QString nom)
{
    QSqlQuery query;
    query.prepare("SELECT NOM FROM COMMANDE WHERE NOM=:nom");
    query.bindValue(":nom", nom);
    query.exec();

    if(query.size()!=nom){return false;}
    else return true;
}
QSqlQueryModel* commande::afficher_qt(QString qt)
{
    QSqlQuery query;
    query.prepare("SELECT * FROM COMMANDE WHERE QT=:qt ");
    query.bindValue(":qt", qt);
    QSqlQueryModel* model= new QSqlQueryModel();
    query.exec();
    model->setQuery(query);
    model->setHeaderData(0, Qt::Horizontal, QObject::tr("CODE"));
    model->setHeaderData(1, Qt::Horizontal, QObject::tr("PRIX"));
    model->setHeaderData(2, Qt::Horizontal, QObject::tr("CP"));
    model->setHeaderData(3, Qt::Horizontal, QObject::tr("QT"));
    model->setHeaderData(4, Qt::Horizontal, QObject::tr("NUM_TELC"));
     model->setHeaderData(5, Qt::Horizontal, QObject::tr("NOM"));;
     model->setHeaderData(6, Qt::Horizontal, QObject::tr("DATC"));

    return model;
}

bool commande::search_qt(QString qt)
{
    QSqlQuery query;
    query.prepare("SELECT QT FROM COMMANDE WHERE QT=:qt");
    query.bindValue(":qt", qt);
    query.exec();

    if(query.size()!=qt){return false;}
    else return true;
}

/*void commande::statistique()
{
    QPieSeries *series = new QPieSeries();
              QChart *chart = new QChart();

 QSqlQuery query;
     int id=0;
     query.prepare("select count(e.id) ,r.departement from employe e inner join role r on e.idRole=r.id group by r.departement ");
     if(query.exec())
      {while(query.next())
         {
              series->append("Jane", 1);
              series->append("Joe", 2);
              series->append("Andy", 3);
              series->append("Barbara", 4);
              series->append("Axel", 5);
          //![1]

          //![2]
              QPieSlice *slice = series->slices().at(1);
              slice->setExploded();
              slice->setLabelVisible();
              slice->setPen(QPen(Qt::darkGreen, 2));
              slice->setBrush(Qt::green);
          //![2]

          //![3]
              chart->addSeries(series);
              chart->setTitle("Simple piechart example");
              chart->legend()->hide();
          //![3]

          //![4]

          //![4]

          //![5]



}
} QChartView *chartView = new QChartView(chart);
                  chartView->setRenderHint(QPainter::Antialiasing);
                               chartView->show();
}*/
