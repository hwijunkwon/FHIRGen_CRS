package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Immunization;

import java.text.ParseException;

//예방접종내역
public class ImmunizationInfo extends BaseResource {
    static int resourceNum = 0;
    Immunization immunization =  new Immunization();

    //접종일자, 예방접종명, 예방접종코드, 백신명, 접종차수
    public ImmunizationInfo(String vaccinationDate, String immunizationName, String immunizationCode, String vaccinationName, String vaccinationNum){
        this.setMetaData(immunization, Terminology.IMMUNIZATION_INFO, resourceNum);

        try {
            immunization.getOccurrenceDateTimeType().setValue(this.simpleDateFormat.parse(vaccinationDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        immunization.getVaccineCode().addCoding()
                .setDisplay(immunizationName)
                .setCode(immunizationCode);
        immunization.getVaccineCode().setText(vaccinationName);
        immunization.addProtocolApplied().getDoseNumberPositiveIntType().setValue(Integer.valueOf(vaccinationNum));
        immunization.setStatus(Immunization.ImmunizationStatus.COMPLETED);

    }

}
