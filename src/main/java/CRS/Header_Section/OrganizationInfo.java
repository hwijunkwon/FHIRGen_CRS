package CRS.Header_Section;

import org.hl7.fhir.r4.model.Organization;
import CRS.Terminology;
import CRS.BaseResource;

//의료기관 정보
public class OrganizationInfo extends BaseResource {
    static int resourceNum = 0;
    Organization organization = new Organization();

    //의료기관 식별번호, 요양기관기호, 요양기관명, 요양기관 연락처, 주소
    public OrganizationInfo(String institutionId, String symbol, String name,
                            String tel, String address){

        this.setMetaData(organization, Terminology.ORGANIZATION_INFO, resourceNum);

        organization.addIdentifier()
                .setValue(institutionId);
        organization
                .addAlias(symbol)
                .setName(name)
                .addAddress().setText(address);
        organization
                .addTelecom().setValue(tel);
    }


}
