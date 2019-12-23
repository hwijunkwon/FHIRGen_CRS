package Image_generator;


import CRS.Body_Section.*;
import CRS.Header_Section.*;
import org.hl7.fhir.r4.model.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGenerator {
    /*
    public static void makeImage(Bundle bundle){
        makeImage1();
        makeImage2();
    }
    */

    public static void  makeImage1(DocumentInfo documentInfo, PatientInfo patientInfo, OrganizationInfo organizationInfo,
                                  PractitionerInfo practitionerInfo, DocumentWriterInfo documentWriterInfo,
                                  DiagnosisInfo diagnosisInfo, MedicationInfo medicationInfo, TestResultInfo spe_testResultInfo, TestResultInfo pat_testResultInfo){

        File makeImage = new File("./src/main/java/Image_generator/result/written_image1.jpg");
        System.out.println("saved New image name : " + makeImage.toString());

        File loadImage = new File("./src/main/java/Image_generator/Image/image1.bmp");
        BufferedImage bi = null;

        try {
            bi = ImageIO.read(loadImage);
        } catch (IOException e) {
            System.out.println("image error");
            e.printStackTrace();
        }

        Graphics2D g2 = bi.createGraphics();
        g2.setColor(Color.black);// 폰트 색상 설정
        g2.setFont(g2.getFont().deriveFont(15f));//폰트 종류 설정

        // 이미지에 텍스트 사입. (text,x축,y축)
        //문서정보
        g2.drawString(documentInfo.name, 240, 170);
        g2.drawString(documentInfo.code, 770, 170);
        g2.drawString(documentInfo.id, 240, 215);
        g2.drawString(documentInfo.requestNumber, 500, 215);

        //환자정보
        g2.drawString(patientInfo.id, 240, 280);
        g2.drawString(patientInfo.name, 500, 280);
        g2.drawString(patientInfo.birth, 770, 280);
        g2.drawString(patientInfo.gender, 240, 336);
        g2.drawString(patientInfo.tel, 500, 336);
        g2.drawString(patientInfo.clinicalCode, 770, 317);
        g2.drawString(patientInfo.clinicalName, 770, 348);
        g2.drawString(patientInfo.address, 240, 390);

        //의료기관정보
        g2.drawString(organizationInfo.institutionId, 240, 450);
        g2.drawString(organizationInfo.symbol, 240, 490);
        g2.drawString(organizationInfo.name, 500, 470);
        g2.drawString(organizationInfo.tel, 770, 470);
        g2.drawString(organizationInfo.address, 240, 533);

        //진료의정보
        g2.drawString(practitionerInfo.name, 240, 600);
        g2.drawString(practitionerInfo.licenceNum, 500, 600);
        g2.drawString(practitionerInfo.tel, 770, 625);
        g2.drawString(practitionerInfo.department, 240, 643);
        g2.drawString(practitionerInfo.departmentCode, 500, 643);

        //문서작성자 정보
        g2.drawString(documentWriterInfo.id, 240, 710);
        g2.drawString(documentWriterInfo.name, 500, 710);
        g2.drawString(documentWriterInfo.tel, 770, 710);

        //진단내역
        g2.drawString(diagnosisInfo.diagnosisDate, 240, 775);
        g2.drawString(diagnosisInfo.diseaseName, 500, 775);
        g2.drawString(diagnosisInfo.diseaseCode, 770, 775);

        //약물처방내역
        g2.drawString(medicationInfo.prescriptionDate, 240, 840);
        g2.drawString(medicationInfo.presciptedMedicineCode, 500, 840);
        g2.drawString(medicationInfo.ingredientName, 770, 840);
        g2.drawString(medicationInfo.doseAmountPerDay, 240, 880);
        g2.drawString(medicationInfo.doseNumPerDay, 500, 880);
        g2.drawString(medicationInfo.ingredientCode, 770, 880);
        g2.drawString(medicationInfo.doseUnitPerDay, 240, 925);
        g2.drawString(medicationInfo.doseDuration, 500, 925);
        g2.drawString(medicationInfo.method, 240, 968);

        //검체검사결과
        g2.drawString(spe_testResultInfo.date, 240, 1045);
        g2.drawString(spe_testResultInfo.testname, 500, 1025);
        g2.drawString(spe_testResultInfo.testTitle, 770, 1025);
        g2.drawString(spe_testResultInfo.testCode, 500, 1058);
        g2.drawString(spe_testResultInfo.referenceRange, 770, 1058);
        g2.drawString(spe_testResultInfo.testResult, 240, 1110);

        //병리검사결과
        g2.drawString(pat_testResultInfo.date, 240, 1185);
        g2.drawString(pat_testResultInfo.testTitle, 500, 1185);
        g2.drawString(pat_testResultInfo.testCode, 770, 1185);
        g2.drawString(pat_testResultInfo.testResult, 240, 1228);

        g2.dispose();

        try {
            ImageIO.write(bi, "jpg", makeImage);
        } catch (IOException e) {
            System.out.print("Image saving error");
            e.printStackTrace();

        }

    }

    public static void  makeImage2(TestResultInfo img_testResultInfo, TestResultInfo fun_testResultInfo, ProcedureInfo procedureInfo,
                                   AllergyInfo allergyInfo, ImmunizationInfo immunizationInfo, VitalsignInfo vitalsignInfo, SmokeInfo smokeInfo,
                                   DrinkInfo drinkInfo, InfectionInfo infectionInfo){
        File makeImage = new File("./src/main/java/Image_generator/result/written_image2.jpg");
        System.out.println("saved New image name : " + makeImage.toString());

        File loadImage = new File("./src/main/java/Image_generator/Image/image2.bmp");
        BufferedImage bi = null;

        try {
            bi = ImageIO.read(loadImage);
        } catch (IOException e) {
            System.out.println("image error");
            e.printStackTrace();
        }

        Graphics2D g2 = bi.createGraphics();
        g2.setColor(Color.black);// 폰트 색상 설정
        g2.setFont(g2.getFont().deriveFont(15f));//폰트 종류 설정

        // 이미지에 텍스트 사입. (text,x축,y축)
        //영상검사결과
        g2.drawString(img_testResultInfo.date, 240, 121);
        g2.drawString(img_testResultInfo.testTitle, 500, 121);
        g2.drawString(img_testResultInfo.testCode, 770, 121);
        g2.drawString(img_testResultInfo.testResult, 240, 180);

        //기능검사결과
        g2.drawString(fun_testResultInfo.date, 240, 250);
        g2.drawString(fun_testResultInfo.testTitle, 500, 250);
        g2.drawString(fun_testResultInfo.testCode, 770, 250);
        g2.drawString(fun_testResultInfo.testResult, 240, 310);

        //수술내역
        g2.drawString(procedureInfo.date, 240, 408);
        g2.drawString(procedureInfo.procedureName, 500, 385);
        g2.drawString(procedureInfo.procedureCode, 500, 428);
        g2.drawString(procedureInfo.anesthesia, 770, 428);
        g2.drawString(procedureInfo.diagnosis, 240, 485);

        //알러지 및 부작용
        g2.drawString(allergyInfo.date, 240, 560);
        g2.drawString(allergyInfo.allergyFactorCode, 500, 560);
        g2.drawString(allergyInfo.allergyName, 770, 560);
        g2.drawString(allergyInfo.allergyFactor, 240, 600);
        g2.drawString(allergyInfo.reaction, 240, 645);

        //예방접종내역
        g2.drawString(immunizationInfo.vaccinationDate, 240, 709);
        g2.drawString(immunizationInfo.vaccinationName, 500, 709);
        g2.drawString(immunizationInfo.immunizationCode, 770, 709);
        g2.drawString(immunizationInfo.immunizationName, 500, 753);
        g2.drawString(immunizationInfo.vaccinationNum, 240, 753);

        //생체신호및 상태
        g2.drawString(vitalsignInfo.date, 240, 818);
        g2.drawString(vitalsignInfo.height, 500, 818);
        g2.drawString(vitalsignInfo.weight, 770, 818);
        g2.drawString(vitalsignInfo.bp_dia, 240, 862);
        g2.drawString(vitalsignInfo.bp_sys, 500, 862);

        //흡연/음주 상태
        g2.drawString(smokeInfo.smokeStatus, 240, 925);
        g2.drawString(smokeInfo.smokeStatusCode, 620, 925);
        g2.drawString(drinkInfo.drinkStatus, 240, 970);
        g2.drawString(drinkInfo.drinkStatusCode, 620, 970);

        //법정 전염성 감염병
        g2.drawString(infectionInfo.onsetDate, 240, 1035);
        g2.drawString(infectionInfo.diagnosisDate, 500, 1035);
        g2.drawString(infectionInfo.reportDate, 770, 1035);
        g2.drawString(infectionInfo.diseaseName, 240, 1078);
        g2.drawString(infectionInfo.patientClassification, 770, 1078);
        g2.drawString(infectionInfo.testResult, 240, 1137);
        g2.drawString(infectionInfo.hospitalization, 240, 1190);
        g2.drawString(infectionInfo.estimatedInfectionArea, 500, 1190);

        g2.dispose();

        try {
            ImageIO.write(bi, "jpg", makeImage);
        } catch (IOException e) {
            System.out.print("Image saving error");
            e.printStackTrace();

        }
    }
}
