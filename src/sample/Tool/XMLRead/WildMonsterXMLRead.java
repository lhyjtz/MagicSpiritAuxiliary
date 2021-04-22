package sample.Tool.XMLRead;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import sample.Tool.Eneity.WildMonsterXMLReadEntity;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @autHor LHYJTZ
 * @data 2021年04月21日 13:37
 * 用于读取XML数据
 */
public class WildMonsterXMLRead {
    private int i = 1;


    public List<WildMonsterXMLReadEntity> WildMonsterReadXML() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("src/sample/XML/WildMonster.xml"));
        System.out.println(document.toString());
        List<WildMonsterXMLReadEntity> list = new ArrayList<>();
        Element root = document.getRootElement();
        for (Iterator<Element> subroot = root.elementIterator(); subroot.hasNext(); ) {
            Element sub = subroot.next();
            for (Iterator<Attribute> attributeIterator = sub.attributeIterator(); attributeIterator.hasNext(); ) {
                Attribute attribute = attributeIterator.next();
                System.out.println("属性的名称：" + attribute.getName() + "\t" + attribute.getValue());
            }
        }
        for (Iterator<Element> elementIterator = root.elementIterator(); elementIterator.hasNext(); ) {
            Element child = elementIterator.next();
            WildMonsterXMLReadEntity wildMonsterXMLReadEntity = new WildMonsterXMLReadEntity();
            for (Iterator<Element> subChild = child.elementIterator(); subChild.hasNext(); ) {
                Element next = subChild.next();
                String Str = next.getName();
                switch (Str) {
                    case "id":
                        wildMonsterXMLReadEntity.setId(Integer.parseInt(next.getText()));
                        break;
                    case "WildMonsterName":
                        wildMonsterXMLReadEntity.setWildMonsterName(next.getText());
                        break;
                    case "WildMonsterGradeRange":
                        wildMonsterXMLReadEntity.setWildMonsterGradeRange(next.getText());
                        break;
                    case "WildMonsterMapID":
                        wildMonsterXMLReadEntity.setWildMonsterMapID(next.getText());
                        break;
                    case "WildMonsterMapName":
                        wildMonsterXMLReadEntity.setWildMonsterMapName(next.getText());
                        break;
                    case "HideWildMonster":
                        wildMonsterXMLReadEntity.setHideWildMonster(next.getText());
                        break;
                }
                System.out.println(next.getName() + "\t" + next.getText());
            }
            list.add(wildMonsterXMLReadEntity);
            System.out.println("=================");

        }

        for (WildMonsterXMLReadEntity employee : list) {
            System.out.println("信息为：" + employee.toString());
        }
        return list;
    }

}
