package com.andersen.trainee.behavioral.chain_of_responsibility;

public class TestNotifier {
    public static void main(String[] args) {
        Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SMSNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("everything is ok", Priority.ROUTINE);
        reportNotifier.notifyManager("we have some problems", Priority.IMPORTANT);
        reportNotifier.notifyManager("we have many problems", Priority.ASAP);
    }
}
