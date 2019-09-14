package cn.lifengming.springioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lifengming
 * @since 15.08.2019
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList;

    public PropertyValues() {
        this.propertyValueList = new ArrayList<PropertyValue>();
    }

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
