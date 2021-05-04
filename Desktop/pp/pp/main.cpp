#include "mainwindow.h"
#include "connexion.h"
#include <QApplication>
#include<QDebug>
#include <QMessageBox>
#include<QFile>
#include <QTranslator>
#include<QInputDialog>
int main(int argc, char *argv[])
{QApplication a(argc, argv);




    QFile styleSheetFile("C:/Users/User/Desktop/Code_source_Atelier_Connexion/Atelier_Connexion/Adaptic.qss");
            styleSheetFile.open(QFile::ReadOnly);
            QString styleSheet=QLatin1String(styleSheetFile.readAll());
            a.setStyleSheet(styleSheet);
    connexion c;
    QTranslator t;
    QStringList languages;
    languages <<"French" <<"English" << "Arabe";

    const QString lang = QInputDialog::getItem(NULL,"Select language",
                                         "language", languages);

    if (lang == "English")
    {
        //t.load("C:/Qt/5.9.9/mingw53_32/translations/qtbase_en.qm");

        t.load(":/anglais.qm");

    }
    else if (lang == "Arabe" )
    {
        t.load(":/arab.qm");
    }
    if(lang !="French"){
        a.installTranslator(&t);
    }
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
