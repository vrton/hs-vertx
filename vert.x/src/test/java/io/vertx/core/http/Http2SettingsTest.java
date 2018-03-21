/*
 * Copyright (c) 2011-2017 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.core.http;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Thomas Segismont
 */
public class Http2SettingsTest {

  @Test
  public void testEqualsHashCode() throws Exception {
    Http2Settings s1 = new Http2Settings().setHeaderTableSize(1024);
    Http2Settings s2 = new Http2Settings().setHeaderTableSize(1024);
    Http2Settings s3 = new Http2Settings(s1.toJson());
    Http2Settings s4 = new Http2Settings().setHeaderTableSize(2048);

    assertEquals(s1, s1);
    assertEquals(s2, s2);
    assertEquals(s3, s3);

    assertEquals(s1, s2);
    assertEquals(s2, s1);
    assertEquals(s2, s3);
    assertEquals(s3, s2);

    assertEquals(s1, s3);
    assertEquals(s3, s1);

    assertEquals(s1.hashCode(), s2.hashCode());
    assertEquals(s2.hashCode(), s3.hashCode());

    assertFalse(s1.equals(null));
    assertFalse(s2.equals(null));
    assertFalse(s3.equals(null));

    assertNotEquals(s1, s4);
    assertNotEquals(s4, s1);
    assertNotEquals(s2, s4);
    assertNotEquals(s4, s2);
    assertNotEquals(s3, s4);
    assertNotEquals(s4, s3);

    assertNotEquals(s1.hashCode(), s4.hashCode());
    assertNotEquals(s2.hashCode(), s4.hashCode());
    assertNotEquals(s3.hashCode(), s4.hashCode());
  }
}
