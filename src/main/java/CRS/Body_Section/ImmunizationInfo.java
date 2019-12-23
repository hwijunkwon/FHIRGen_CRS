package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.Resource;

import java.text.ParseException;

//예방접종내역
public class ImmunizationInfo extends BaseResource {
    static int resourceNum = 0;
    Immunization immunization ;
    public String vaccinationDate,  immunizationName,  immunizationCode,  vaccinationName,  vaccinationNum;

    public ImmunizationInfo(Resource resource){
        immunization = (Immunization) resource;
    }

    //접종일자, 예방접종명, 예방접종코드, 백신명, 접종차수
    public ImmunizationInfo(String vaccinationDate, String immunizationName, String immunizationCode, String vaccinationName, String vaccinationNum){
        immunization =  new Immunization();
        this.setMetaData(immunization, Terminology.IMMUNIZATION_INFO, resourceNum);
        this.vaccinationDate = vaccinationDate;
        this.immunizationName = immunizationName;
        this.immunizationCode = immunizationCode;
        this.vaccinationName = vaccinationName;
        this.vaccinationNum = vaccinationNum;

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
