#include "mainwindow.h"
#include "connexion.h"
#include <QApplication>
#include<QDebug>
#include <QMessageBox>
#include<QFile>
#include<QTranslator>
#include<QInputDialog>
int main(int argc, char *argv[])
{QApplication a(argc, argv);




    QFile styleSheetFile("C:/Users/User/Desktop/Code_source_Atelier_Connexion/Atelier_Connexion/Adaptic.qss");
            styleSheetFile.open(QFile::ReadOnly);
            QString styleSheet=QLatin1String(styleSheetFile.readAll());
            a.setStyleSheet(styleSheet);

    connexion c;
    QTranslator T ;
    QStringList langs ;
    langs <<"english"<<"frensh"<<"arabe";
    const QString lang = QInputDialog :: getItem(NULL,"language","Select a language",langs);
    if (lang == "english"){
        T.load(":/new/prefix1/english.qm");

    }else if(lang=="arabe")
    { T.load(":/new/prefix1/arabe.qm");}
    if (lang!= "frensh"){
        a.installTranslator(&T)  ;}
    bool test=c.createconnexion();
     MainWindow w;

    if(test) QMessageBox::information(nullptr, QObject::tr("database is open"),QObject::tr("connexion reussite\n" "click OK to exist"),
                                       QMessageBox::Ok);
         //qDebug() <<"connexion reussite";


     else
         QMessageBox::critical(nullptr, QObject::tr("database is not open"),QObject::tr("connexion failed\n" "click Cancel to exist"),
                                                QMessageBox::Cancel);
         //qDebug() <<"erreur de connexion";
     w.show();
    return a.exec();
}
