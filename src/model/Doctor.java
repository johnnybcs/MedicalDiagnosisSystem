package model;

import java.util.HashMap;
import java.util.Map;

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
    private static boolean chronic;

    private String diagnosis;


    public Doctor() {
        uri = 0;
        copd = 0;
        pneumonia = 0;
        chronicBronchitis = 0;
        postnasalDrip = 0;
        postInfectionCough = 0;
        gerd = 0;
        chronic = false;
        diagnosis = "";
    }

    public void reply(String userInput) {
        switch (Root.questionNumber) {
            case (0):
                if (userInput.contains("cough")) {
                    doctorResponse("How long have you had the cough for?");
                } else {
                    doctorResponse("I'm sorry, I can only diagnose coughs.");
                }
                break;
            case (1):
                try {
                    duration = Integer.parseInt(userInput.replaceAll("[^0-9]+", ""));
                } catch (Exception e) {
                    doctorResponse("Sorry, I didn't get that. How many weeks did you have the cough for?");
                }

                if (userInput.contains("day") && duration < 21) {
                    acuteCoughQuestions(userInput, 1);
                } else if (userInput.contains("week") && duration < 3) {
                    acuteCoughQuestions(userInput, 1);

                } else if ((userInput.contains("week") && duration >= 3)
                        || userInput.contains("month") || userInput.contains("year")) {
                    chronic = true;
                    chronicCoughQuestions(userInput, 1);

                } else {
                    doctorResponse("Sorry, I didn't get that. Please reply with a yes or no.");
                }
                break;
            case (2):
                selectQuestions(userInput, 2);
                break;
            case (3):
                selectQuestions(userInput, 3);
                break;
            case (4):
                selectQuestions(userInput, 4);
                break;
            case (5):
                selectQuestions(userInput, 5);
                break;
            case (6):
                selectQuestions(userInput, 6);
                break;
            case (7):
                selectQuestions(userInput, 7);
                break;
            case (8):
                selectQuestions(userInput, 8);
                break;
        }

    }

    private void selectQuestions(String userInput, int i) {
        if (!chronic) {
            acuteCoughQuestions(userInput, i);

        } else {
            chronicCoughQuestions(userInput, i);

        }
    }

    private void doctorResponse(String string) {
        if (!string.contains("sorry")) {
            Root.questionNumber++;
        }
        textArea.appendText(DOCTOR_NAME + string + "\n");
    }

    private void acuteCoughQuestions(String userInput, int questionNumber) {
        switch (questionNumber) {
            case (1):
                doctorResponse("Have you been around people with similar symptoms?");

                break;
            case (2):
                if (userInput.contains("yes")) {
                    uri++;
                } else {
                    uri--;
                }
                doctorResponse("Do you have a sore or scratchy throat, or a runny or congested nose?");

                break;
            case (3):
                if (userInput.contains("yes")) {
                    uri++;
                } else {
                    uri--;
                }
                doctorResponse("Do you have a fever?");

                break;
            case (4):
                if (userInput.contains("yes")) {
                    pneumonia++;
                    uri--;
                } else {
                    pneumonia--;
                    uri++;
                }
                doctorResponse("Do you have trouble breathing?");

                break;
            case (5):
                if (userInput.contains("yes")) {
                    pneumonia++;
                    copd++;
                    uri--;
                } else {
                    pneumonia--;
                    copd--;
                    uri++;
                }
                doctorResponse("Does it hurt to breathe or cough?");

                break;
            case (6):
                if (userInput.contains("yes")) {
                    pneumonia++;
                    uri--;
                } else {
                    pneumonia--;
                    uri++;
                }
                doctorResponse("Do you have nausea, vomiting, or diarrhea?");

                break;
            case (7):
                if (userInput.contains("yes")) {
                    pneumonia++;
                    postnasalDrip++;
                    uri--;
                } else {
                    pneumonia--;
                    uri++;
                }
                doctorResponse("Do you smoke?");

                break;
            case (8):
                if (userInput.contains("yes")) {
                    copd += 2;
                } else {
                    copd -= 2;
                }
                getDiagnosis();
                doctorResponse("You most likely have " + this.diagnosis + ". " + getDescription() + " " + getTreatment());
                break;
        }
    }

    private void chronicCoughQuestions(String userInput, int questionNumber) {
        switch (questionNumber) {
            case (1):
                doctorResponse("Have you recently had a cold?");

                break;
            case (2):
                if (userInput.contains("yes")) {
                    postInfectionCough += 2;
                } else {
                    postInfectionCough += 2;
                }
                doctorResponse("Do you have heartburn, a burning sensation in you chest?");

                break;
            case (3):
                if (userInput.contains("yes")) {
                    gerd += 2;
                } else {
                    gerd -= 2;
                }
                doctorResponse("Do you feel like you have a something in your throat?");

                break;
            case (4):
                if (userInput.contains("yes")) {
                    gerd++;
                    postnasalDrip++;
                } else {
                    gerd--;
                    postnasalDrip--;
                }
                doctorResponse("Is your cough worse at night?");

                break;
            case (5):
                if (userInput.contains("yes")) {
                    postnasalDrip++;
                } else {
                    postnasalDrip--;
                }
                doctorResponse("Do you have bad breath?");

                break;
            case (6):
                if (userInput.contains("yes")) {
                    postnasalDrip++;
                } else {
                    postnasalDrip--;
                }
                doctorResponse("Do you often clear your throat?");

                break;
            case (7):
                if (userInput.contains("yes")) {
                    postnasalDrip++;
                } else {
                    postnasalDrip--;
                }
                doctorResponse("Do you have trouble breathing?");

                break;
            case (8):
                if (userInput.contains("yes")) {
                    chronicBronchitis++;
                } else {
                    chronicBronchitis--;
                }
                getDiagnosis();
                doctorResponse("You most likely have " + this.diagnosis + ". " + getDescription() + " " + getTreatment());
        }
    }

    private void getDiagnosis() {
        Map<String, Integer> diagnoses = new HashMap<>();
        diagnoses.put("an upper respiratory infection", uri);
        diagnoses.put("a chronic obstructive pulmonary disease exacerbation", copd);
        diagnoses.put("pneumonia", pneumonia);
        diagnoses.put("chronic bronchitis", chronicBronchitis);
        diagnoses.put("postnasal drip", postnasalDrip);
        diagnoses.put("postInfection cough", postInfectionCough);
        diagnoses.put("gastroesophageal reflux disease", gerd);

        int max = -100;
        for (Map.Entry<String, Integer> entry : diagnoses.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                this.diagnosis = entry.getKey();
            }
        }
    }

    private String getDescription() {
        switch (this.diagnosis) {
            case ("an upper respiratory infection"):
                return "Also known as the common cold, this illness is caused by a viral infection of your upper respiratory tract.";
            case ("a chronic obstructive pulmonary disease exacerbation"):
                return "COPD is a progressive lung disease characterized by non-reversible breathlessness. The most common type of COPD is caused by smoking.";
            case ("pneumonia"):
                return "Pneumonia is an infection of the air sacs in the lungs.";
            case ("chronic bronchitis"):
                return "Chronic bronchitis is an inflammation of the airways that carry air to and from your lungs.";
            case ("postnasal drip"):
                return "Postnasal drip is a buildup of mucus at the back of your nose and throat.";
            case ("a postInfection cough"):
                return "A cough that persists after a viral respiratory infection is called a post-infection cough.";
            case ("gastroesophageal reflux disease"):
                return "GERD occurs when acid from your stomach frequently flows back into your esophagus, the tube connecting your mouth to your stomach.";
            default:
                return "";
        }
    }

    private String getTreatment() {
        switch (this.diagnosis) {
            case ("an upper respiratory infection"):
                return "Your symptoms should resolve within 10 days without any treatment. Take acetaminophen to alleviate discomfort.";
            case ("a chronic obstructive pulmonary disease exacerbation"):
                return "Treatment includes smoking cessation, inhaled bronchodilators and corticosteroids, and oxygen therapy.";
            case ("pneumonia"):
                return "It is treated with antibiotics.";
            case ("chronic bronchitis"):
                return "Inhaled bronchodilators and corticosteroids can reduce inflammation and open the narrowed passages in your lungs.";
            case ("postnasal drip"):
                return "You can use saline nasal sprays or irrigation to flush irritants, such mucus, allergens, and bacteria, out of your sinuses.";
            case ("postInfection cough"):
                return "Inhale anticholinergics and steroids can be used to control it.";
            case ("gastroesophageal reflux disease"):
                return "You may be able to control GERD by reducing your intake of greasy or spicy foods and alcoholic drinks, not overeating, and not eating 2 hours before bedtime.";
            default:
                return "";
        }
    }
}
