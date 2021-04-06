#ifndef NOTIFICATION_H
#define NOTIFICATION_H

#include <QSystemTrayIcon>
#include<QString>
class Notification
{
public:
    Notification();
    void notification_ajoutReclamation();
    void notification_ajoutPromotion();
    void notification_supprimerReclamation();
    void notification_supprimerPromotion();
    void notification_modifierReclamation();
    void notification_modifierpromotion();







};

#endif // NOTIFICATION_H
