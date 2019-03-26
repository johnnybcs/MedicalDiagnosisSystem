# MedicalDiagnosisSystem
<B>Purpose:</B> This chatbot can diagnose medical diseases.

<B>Instructions:</B> Tell the chatbot about your symptoms. He will try his best to diagnose the root of your problems and suggest a treatment.

\
<B>Examples:</B>
\
<I>Diagnosis of an upper respiratory tract infection</I>
\
<img width="496" alt="2" src="https://user-images.githubusercontent.com/47739019/54882997-855d1980-4e1d-11e9-8b91-c2cc0748f6b1.png">

\
<I>Diagnosis of gastroesophageal reflux disease</I>
\
<img width="498" alt="1" src="https://user-images.githubusercontent.com/47739019/54882996-855d1980-4e1d-11e9-8fc4-edec1cbcc4c4.png">

\
<B>Notes:</B>
- At the moment, the chatbot can only diagnose the 6 most common causes of coughs in adults. His knowledge base can be infinitely expanded in the future.
- The accuracy of the diagnosis is limited by the lack of a physical exam, laboratory testing, and diagnostic imaging.
- The chatbot emulates the thinking of a doctor. It comes up with a list of the most probable diagnoses based on the patient's reported symptoms. Then it asks a series of questions to narrow down the diagnosis. Its questions dependent on the patient's previous responses.
- Patients can be notoriously bad historians. Furthermore, diseases often don't fit the same pattern of symptoms. The chatbot accounts for these issues in the following ways:
    - Not all questions it asks have the same weighting. Some questions are more indicative of a particular diagnosis than others.
    - A patient's response to a question does not completely rule out or confirm a particular diagnosis, but decreases or increases the likelihood of each probable diagnosis.
    - After the chatbot has finished taking the patient's history, it analyzes all the information that it has learned from the patient and comes up with the most likely cause of the patient's reported symptoms.