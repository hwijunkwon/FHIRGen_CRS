package CRS.Header_Section;

import org.hl7.fhir.r4.model.Person;
import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Resource;

//문서생성자 정보
public class DocumentWriterInfo extends BaseResource {
    static int resourceNum = 0;
    Person person;
    public String id,name, tel;

    public DocumentWriterInfo(Resource resource){
        person = (Person) resource;
    }

    //문서작성자 ID, 문서작성자 성명, 문서작성자 연락처
    public DocumentWriterInfo(String id, String name, String tel){
        person = new Person();
        this.setMetaData(person, Terminology.DOCUMENTWRITER_INFO, resourceNum);
        this.id = id;
        this.name = name;
        this.tel = tel;

        person.addIdentifier().setValue(id);
        person.addName().setText(name);
        person.addTelecom().setValue(tel);
    }


}
