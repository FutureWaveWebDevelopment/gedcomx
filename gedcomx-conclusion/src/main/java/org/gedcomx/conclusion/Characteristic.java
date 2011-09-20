/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.conclusion;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.RDFSubClassOf;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.CharacteristicType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A conclusion about a characteristic of a person or relationship.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Characteristic", propOrder = {"type", "date", "place", "value"})
@RDFSubClassOf ( CommonNamespaces.DUBLIN_CORE_TYPE_NAMESPACE + "Event" )
public class Characteristic extends Conclusion implements Typed<CharacteristicType>, Spatial, Temporal {

  private TypeReference<CharacteristicType> type;
  private Date date;
  private Place place;
  private String value;


  /**
   * The type of the characteristic.
   *
   * @return The type of the characteristic.
   */
  @XmlElement (namespace = CommonNamespaces.RDF_NAMESPACE)
  public TypeReference<CharacteristicType> getType() {
    return type;
  }

  /**
   * The type of the characteristic.
   *
   * @param type The type of the characteristic.
   */
  public void setType(TypeReference<CharacteristicType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the characteristic, or {@link org.gedcomx.types.CharacteristicType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the characteristic, or {@link org.gedcomx.types.CharacteristicType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public org.gedcomx.types.CharacteristicType getKnownType() {
    return getType() == null ? null : XmlQNameEnumUtil.fromURI(getType().getType(), CharacteristicType.class);
  }

  /**
   * Set the type of this characteristic from a known enumeration of types.
   *
   * @param knownType The known type.
   */
  @JsonIgnore
  public void setKnownType(CharacteristicType knownType) {
    setType(knownType == null ? null : new TypeReference<CharacteristicType>(knownType));
  }

  /**
   * The date of applicability of this characteristic.
   *
   * @return The date of applicability of this characteristic.
   */
  public Date getDate() {
    return date;
  }

  /**
   * The date of applicability of this characteristic.
   *
   * @param date The date of applicability of this characteristic.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * The place of applicability of this characteristic.
   *
   * @return The place of applicability of this characteristic.
   */
  public Place getPlace() {
    return place;
  }

  /**
   * The place of applicability of this characteristic.
   *
   * @param place The place of applicability of this characteristic.
   */
  public void setPlace(Place place) {
    this.place = place;
  }

  /**
   * The value of this characteristic.
   *
   * @return The value of this characteristic.
   */
  public String getValue() {
    return value;
  }

  /**
   * The value of this characteristic.
   *
   * @param value The value of this characteristic.
   */
  public void setValue(String value) {
    this.value = value;
  }
}
