package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Resource;

import java.text.ParseException;

//생체신호 및 상태
public class VitalsignInfo extends BaseResource {
    static int resourceNum = 0;
    Observation observation;
    public String date,  height,  weight,  bp_dia,  bp_sys,  temperature;

    public VitalsignInfo(Resource resource){
        observation = (Observation)resource;
    }

    //측정일자, 키, 몸무게, 혈압(확장기), 혈압(수축기), 체온,
    public VitalsignInfo(String date, String height, String weight, String bp_dia, String bp_sys, String temperature){
        observation = new Observation();
        this.setMetaData(observation, Terminology.VITAL_INFO, resourceNum);
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.bp_dia = bp_dia;
        this.bp_sys = bp_sys;
        this.temperature = temperature;

        try {
            observation.getEffectiveDateTimeType().setValue(this.simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //키
        Observation.ObservationComponentComponent height_comp = observation.addComponent();
        height_comp.getCode().addCoding()
                .setSystem(Terminology.LOINC)
                .setCode(Terminology.LOINC_HEIGHT)
                .setDisplay("Body height");
        height_comp.getValueStringType().setValue(height);

        //몸무게
        Observation.ObservationComponentComponent weight_comp = observation.addComponent();
        weight_comp.getCode().addCoding()
                .setSystem(Terminology.LOINC)
                .setCode(Terminology.LOINC_WEIGHT)
                .setDisplay("Body weight Measured");
        weight_comp.getValueStringType().setValue(weight);

        //확장기혈압
        Observation.ObservationComponentComponent bp_dia_comp = observation.addComponent();
        bp_dia_comp.getCode().addCoding()
                .setSystem(Terminology.LOINC)
                .setCode(Terminology.LOINC_BP_DIA)
                .setDisplay("Diastolic blood pressure");
        bp_dia_comp.getValueStringType().setValue(bp_dia);

        //수축기혈압
        Observation.ObservationComponentComponent bp_sys_comp = observation.addComponent();
        bp_sys_comp.getCode().addCoding()
                .setSystem(Terminology.LOINC)
                .setCode(Terminology.LOINC_BP_SYS)
                .setDisplay("Systolic blood pressure");
        bp_sys_comp.getValueStringType().setValue(bp_sys);

        //체온
        Observation.ObservationComponentComponent temp_comp = observation.addComponent();
        temp_comp.getCode().addCoding()
                .setSystem(Terminology.LOINC)
                .setCode(Terminology.LOINC_TEMPERATURE)
                .setDisplay("Body temperature");
        temp_comp.getValueStringType().setValue(temperature);
    }

}
