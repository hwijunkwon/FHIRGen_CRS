package CRS.Body_Section;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import CRS.BaseResource;
import CRS.Terminology;
import org.hl7.fhir.r4.model.QuestionnaireResponse;
import org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent;
import org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent;
import org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus;
import org.hl7.fhir.r4.model.Reference;

//K-IADL설문지
public class QuestionnaireResponseInfo extends BaseResource {
	static int resourceNum = 0;
	QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();

	//날짜, 환자이름, 환자id, 검사자이름, 1번점수, 2번점수, ...
	public QuestionnaireResponseInfo(String date, String Patientname, String patientId, String PractionerName,
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String Q7, String Q8, String Q9,
			String Q10, String Q11) {

		this.setMetaData(questionnaireResponse, Terminology.QUESTIONNAIRERESPONSE_INFO, resourceNum);

		try {
			questionnaireResponse.setAuthored(this.simpleDateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		questionnaireResponse.setStatus(QuestionnaireResponseStatus.COMPLETED);

		questionnaireResponse.getSubject().setDisplay(Patientname);
		questionnaireResponse.getSubject().setId(patientId);

		questionnaireResponse.getSource().setDisplay(PractionerName);

		List<QuestionnaireResponseItemComponent> theItem = new ArrayList<QuestionnaireResponseItemComponent>();

		QuestionnaireResponseItemComponent arg1 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg2 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg3 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg4 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg5 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg6 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg7 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg8 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg9 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg10 = new QuestionnaireResponseItemComponent();
		QuestionnaireResponseItemComponent arg11 = new QuestionnaireResponseItemComponent();

		arg1.addAnswer().getValueStringType().setValue(Q1);
		arg2.addAnswer().getValueStringType().setValue(Q2);
		arg3.addAnswer().getValueStringType().setValue(Q3);
		arg4.addAnswer().getValueStringType().setValue(Q4);
		arg5.addAnswer().getValueStringType().setValue(Q5);
		arg6.addAnswer().getValueStringType().setValue(Q6);
		arg7.addAnswer().getValueStringType().setValue(Q7);
		arg8.addAnswer().getValueStringType().setValue(Q8);
		arg9.addAnswer().getValueStringType().setValue(Q9);
		arg10.addAnswer().getValueStringType().setValue(Q10);
		arg11.addAnswer().getValueStringType().setValue(Q11);
		theItem.add(arg1);
		theItem.add(arg2);
		theItem.add(arg3);
		theItem.add(arg4);
		theItem.add(arg5);
		theItem.add(arg6);
		theItem.add(arg7);
		theItem.add(arg8);
		theItem.add(arg9);
		theItem.add(arg10);
		theItem.add(arg11);

		questionnaireResponse.setItem(theItem);
	}
}
