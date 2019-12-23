package CRS.Header_Section;

import org.hl7.fhir.r4.model.*;
import CRS.Terminology;
import CRS.BaseResource;

import java.text.ParseException;

//환자 정보
public class PatientInfo extends BaseResource {
    static int resourceNum = 0;
    Patient patient ;
    public String id,name,birth, gender, tel, address, clinicalCode,  clinicalName;

    public PatientInfo(Resource resource){
        patient = (Patient) resource;
    }

    //환자id, 성명, 생년월일, 환자성별코드명칭, 환자성별코드, 연락처, 주소,  진료구분코드,진료구분코드명칭
    public PatientInfo(String id, String name,String birth, Enumerations.AdministrativeGender gender, String tel, String address,
                       String clinicalCode, String clinicalName) {
        patient = new Patient();
        this.setMetaData(patient, Terminology.PATIENT_INFO, resourceNum);
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender = gender.toString();
        this.tel = tel;
        this. address = address;
        this.clinicalCode = clinicalCode;
        this.clinicalName = clinicalCode;

        patient.addIdentifier()
                .setValue(id)
                .getType().addCoding()
                    .setCode(clinicalCode)
                    .setDisplay(clinicalName);

        patient.addName().setText(name);
        try {
            patient.setBirthDate(this.simpleDateFormat.parse(birth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        patient.setGender(gender);
        patient.addTelecom().setValue(tel);
        patient.addAddress().setText(address);
    }

    public String getPatientId(){
        return patient.getIdentifier().get(0).getId();
    }
}
