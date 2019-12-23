package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.Resource;

import java.text.ParseException;

//약물처방내역
public class MedicationInfo extends BaseResource {
    static int resourceNum = 0;
    MedicationStatement medicationStatement;
    public String prescriptionDate,  presciptedMedicinName,  presciptedMedicineCode, ingredientName, ingredientCode, doseAmountPerDay, doseUnitPerDay, doseNumPerDay, doseDuration, method;

    public MedicationInfo(Resource resource){
        medicationStatement = (MedicationStatement)resource;
    }

    //처방일시, 처방약품명, 처방약품코드, 주성분명, 주성분코드, 용량, 복용단위, 횟수, 투여기간, 용법
    public MedicationInfo(String prescriptionDate, String presciptedMedicinName, String presciptedMedicineCode,
                          String ingredientName, String ingredientCode, String doseAmountPerDay, String doseUnitPerDay
                            , String doseNumPerDay, String doseDuration, String method){

        medicationStatement = new MedicationStatement();
        this.setMetaData(medicationStatement, Terminology.MEDICATION_INFO, resourceNum);
        this.prescriptionDate = prescriptionDate;
        this.presciptedMedicinName = presciptedMedicinName;
        this.presciptedMedicineCode = presciptedMedicineCode;
        this.ingredientName = ingredientName;
        this.ingredientCode = ingredientCode;
        this.doseAmountPerDay = doseAmountPerDay;
        this.doseUnitPerDay = doseUnitPerDay;
        this.doseNumPerDay = doseNumPerDay;
        this.doseDuration = doseDuration;
        this.method = method;

        try {
            medicationStatement.setDateAsserted(this.simpleDateFormat.parse(prescriptionDate))
            .getMedicationCodeableConcept().addCoding()
            .setDisplay(presciptedMedicinName)
            .setCode(presciptedMedicineCode);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        medicationStatement.getCategory().addCoding()
                .setDisplay(ingredientName)
                .setCode(ingredientCode);

        medicationStatement.addDosage()
                .getMaxDosePerPeriod().getDenominator()
                .setValue(Integer.valueOf(doseAmountPerDay))
                .setUnit(doseUnitPerDay);

        medicationStatement.getDosageFirstRep()
                .getMaxDosePerPeriod().getNumerator()
                .setValue(Integer.valueOf(doseNumPerDay));

        medicationStatement.getDosageFirstRep().getTiming().getRepeat()
                .setDuration(Integer.valueOf(doseDuration));

        medicationStatement.getDosageFirstRep().setText(method);

    }


}
