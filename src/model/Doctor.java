package model;

        import static model.Root.DOCTOR_NAME;
import static model.Root.textArea;

public class Doctor {
    private static int uri;
    private static int copd;
    private static int pneumonia;

    private static int chronicBronchitis;
    private static int postnasalDrip;
    private static int postInfectionCough;
    private static int gerd;
    private static int duration;


    public Doctor() {
        uri = 0;
        copd = 0;
        pneumonia = 0;
        chronicBronchitis = 0;
        postnasalDrip = 0;
        postInfectionCough = 0;
        gerd = 0;
    }

    public void reply(String userInput, int questionNumber) {
        switch (questionNumber) {
            case (0):
                if (userInput.contains("cough")) {
                    doctorResponse("How long have you had the cough for?");
                    Root.questionNumber++;
                } else {
                    doctorResponse("I'm sorry, I can only diagnose coughs.");
                }
                break;
            case (1):
                try {
                    duration = Integer.parseInt(userInput.replaceAll("[^0-9]+", ""));
                } catch (Exception e) {
                    doctorResponse("I didn't get that. How many weeks did you have the cough for?");
                }

                if (userInput.contains("days") && duration < 21) {
                    doctorResponse("You have an acute cough");
                    Root.questionNumber++;
                } else if (userInput.contains("week") && duration < 3) {
                    doctorResponse("You have an acute cough");
                } else if ((userInput.contains("week") && duration >= 3)
                || userInput.contains("month") || userInput.contains("year")) {
                    doctorResponse("You have a chronic cough");
                } else {
                    doctorResponse("I didn't get that. How many weeks did you have the cough for?");
                }
                break;
        }

    }

    private void doctorResponse(String string) {
        textArea.appendText(DOCTOR_NAME + string + "\n");
    }

}
