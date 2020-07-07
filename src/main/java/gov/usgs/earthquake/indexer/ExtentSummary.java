/**
 * ExtentSummary
 */
package gov.usgs.earthquake.indexer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import gov.usgs.util.XmlUtils;

/**
 * Stores ExtentSummary information for products.
 */
public class ExtentSummary {
  private Long id;
  private Date startTime;
  private Date endTime;
  private BigDecimal maxLatitude;
  private BigDecimal minLatitude;
  private BigDecimal maxLongitude;
  private BigDecimal minLongitude;

  public static final String EXTENT_START_TIME_PROPERTY = "starttime";
  public static final String EXTENT_END_TIME_PROPERTY = "endtime";
  public static final String EXTENT_MAX_LAT_PROPERTY = "maximum-latitude";
  public static final String EXTENT_MIN_LAT_PROPERTY = "minimum-latitude";
  public static final String EXTENT_MAX_LONG_PROPERTY = "maximum-longitude";
  public static final String EXTENT_MIN_LONG_PROPERTY = "minimum-longitude";


  public ExtentSummary() {
    //Do nothing; this is if member vars are to be set manually
  }

  /**
   * Builds an extentSummary from product properties. If the product has none of
   * the properties, the ExtentSummary is still built.
   * 
   * @param product the productSummary to build from
   */
  public ExtentSummary(ProductSummary product) {
    Map<String,String> properties = product.getProperties();

    id = product.getIndexId();

    if (properties.get(EXTENT_START_TIME_PROPERTY) != null) {
      startTime = XmlUtils.getDate(properties.get(EXTENT_START_TIME_PROPERTY));
    }
    if (properties.get(EXTENT_END_TIME_PROPERTY) != null) {
      endTime = XmlUtils.getDate(properties.get(EXTENT_END_TIME_PROPERTY));
    }
    if (properties.get(EXTENT_MAX_LAT_PROPERTY) != null) {
      maxLatitude = new BigDecimal(properties.get(EXTENT_MAX_LAT_PROPERTY));
    }
    if (properties.get(EXTENT_MAX_LONG_PROPERTY) != null) {
      maxLongitude = new BigDecimal(properties.get(EXTENT_MAX_LONG_PROPERTY));
    }
    if (properties.get(EXTENT_MIN_LAT_PROPERTY) != null) {
      minLatitude = new BigDecimal(properties.get(EXTENT_MIN_LAT_PROPERTY));
    }
    if (properties.get(EXTENT_MIN_LONG_PROPERTY) != null) {
      minLongitude = new BigDecimal(properties.get(EXTENT_MIN_LONG_PROPERTY));
    }
  }

  /**
   * Returns TRUE if this extent should be put in the extentSummary table (at
   * least one property is not null)
   */
  public boolean isValid() {
    return 
      startTime != null || 
      endTime != null || 
      maxLatitude != null || 
      maxLongitude != null || 
      minLatitude != null || 
      minLongitude != null;
  }

  public Long getIndexId() {
    return this.id;
  }
  public void setIndexId(Long id) {
    this.id = id;
  }

  public Date getStartTime() {
    return this.startTime;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
  
  public Date getEndTime() {
    return this.endTime;
  }
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public BigDecimal getMaxLatitude() {
    return this.maxLatitude;
  }
  public void setMaxLatitude(BigDecimal maxLatitude) {
    this.maxLatitude = maxLatitude;
  }

  public BigDecimal getMinLatitude() {
    return this.minLatitude;
  }
  public void setMinLatitude(BigDecimal minLatitude) {
    this.minLatitude = minLatitude;
  }

  public BigDecimal getMaxLongitude() {
    return this.maxLongitude;
  }
  public void setMaxLongitude(BigDecimal maxLongitude) {
    this.maxLongitude = maxLongitude;
  }

  public BigDecimal getMinLongitude() {
    return this.minLongitude;
  }
  public void setMinLongitude(BigDecimal minLongitude) {
    this.minLongitude = minLongitude;
  }

} 