package com.accolite.au.y2021.mt._90legacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

/**
 * 
 * @author sree
 * Students to explore on the below classes from JDK.
 */
public class LegacyThreadSafeClasses {
	Vector<String> v;
	Hashtable<String, Object> ht;
	Collection<String> syncCol = Collections.synchronizedList(new ArrayList<>());
}
