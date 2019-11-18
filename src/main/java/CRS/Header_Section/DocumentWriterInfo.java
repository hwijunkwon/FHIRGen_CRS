package CRS.Header_Section;

import org.hl7.fhir.r4.model.Person;
import CRS.Terminology;
import CRS.BaseResource;

//문서생성자 정보
public class DocumentWriterInfo extends BaseResource {
    static int resourceNum = 0;
    Person person = new Person();

    //문서작성자 ID, 문서작성자 성명, 문서작성자 연락처
    public DocumentWriterInfo(String id, String name, String tel){
        this.setMetaData(person, Terminology.DOCUMENTWRITER_INFO, resourceNum);
        person.addIdentifier().setValue(id);
        person.addName().setText(name);
        person.addTelecom().setValue(tel);
    }


}
