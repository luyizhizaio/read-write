package com.uuzz.los.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

public abstract class CollectionUtils extends org.apache.commons.collections.CollectionUtils
{
  public static Collection<String> split(String str)
  {
    Collection coll = new ArrayList();
    if (StringUtils.isNotBlank(str)) {
      addAll(coll, str.split(","));
    }
    return coll;
  }

  public static List fetchPropertyToList(Collection collection, String propertyName)
  {
    List list = new ArrayList();
    try {
      for (Iterator localIterator = collection.iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
        list.add(PropertyUtils.getProperty(obj, propertyName)); }
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }

    return list;
  }

  public static String fetchPropertyToString(Collection collection, String propertyName, String separator)
    throws Exception
  {
    List list = fetchPropertyToList(collection, propertyName);
    return StringUtils.join(list, separator);
  }

/*  public static <T, ID> void mergeByCheckedIds(Collection<T> collection, Collection<ID> checkedIds, Class<T> clazz)
    throws Exception
  {
    mergeByCheckedIds(collection, checkedIds, "id", clazz);
  }*/

  /*public static <T, ID> void mergeByCheckedIds(Collection<T> collection, Collection<ID> checkedIds, String idName, Class<T> clazz)
    throws Exception
  {
    if (checkedIds == null) {
      collection.clear();
      return;
    }

    Iterator it = collection.iterator();

    while (it.hasNext()) {
      Object obj = it.next();
      if (checkedIds.contains(PropertyUtils.getProperty(obj, idName)))
        checkedIds.remove(PropertyUtils.getProperty(obj, idName));
      else {
        it.remove();
      }
    }

    for (Object id : checkedIds) {
      Object obj = clazz.newInstance();
      PropertyUtils.setProperty(obj, idName, id);
      collection.add(obj);
    }
  }*/

  public static int removeAll(Collection collection, Object[] remove)
  {
    if (remove == null) {
      return 0;
    }
    int removeCount = 0;
    for (Object obj : remove) {
      if (collection.remove(obj)) {
        removeCount++;
      }
    }
    return removeCount;
  }

  public static Collection removeAll(Collection collection, Collection remove)
  {
    return ListUtils.removeAll(collection, remove);
  }

  public static Map buildMap(Object[] objs)
  {
    if (objs.length == 0) {
      return new HashMap();
    }
    Assert.isTrue(objs.length % 2 == 0);
    Map map = new HashMap();
    for (int i = 0; i < objs.length; i += 2) {
      map.put(objs[i], objs[(i + 1)]);
    }

    return map;
  }
}