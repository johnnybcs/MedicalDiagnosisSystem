package model;

        import static model.Root.DOCTOR_NAME;
        import static model.Root.textArea;

public class Doctor {

    public Doctor() {
    }

    public void reply(String userInput) {

        if (userInput.contains("cough")) {
            diagnoseCough();
        } else {
            doctorResponse("I'm sorry, I can only diagnose coughs.");
        }
    }

    private void doctorResponse(String string) {
        textArea.appendText(DOCTOR_NAME + string + "\n");
    }

    private void diagnoseCough() {
        doctorResponse("How long have you had the cough for?");
    }

}
