/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
package org.gedcomx.links;

import org.gedcomx.common.URI;

import java.util.List;

/**
 * Interface for basic link support.
 *
 * @author Ryan Heaton
 */
public interface SupportsLinks {

  /**
   * The list of hypermedia links.
   *
   * @return The list of hypermedia links.
   */
  List<Link> getLinks();

  /**
   * The list of hypermedia links.
   *
   * @param links The list of hypermedia links.
   */
  void setLinks(List<Link> links);

  /**
   * Add a hypermedia link.
   *
   * @param link The hypermedia link.
   */
  void addLink(Link link);

  /**
   * Add a hypermedia link.
   *
   * @param rel The link rel.
   * @param href The target URI.
   */
  void addLink(String rel, URI href);

  /**
   * Add a templated link.
   *
   * @param rel The link rel.
   * @param template The link template.
   */
  void addTemplatedLink(String rel, String template);

  /**
   * Get a link by its rel.
   *
   * @param rel The link rel.
   * @return The link by rel.
   */
  Link getLink(String rel);

  /**
   * Get a list of links by rel.
   *
   * @param rel The rel of the links.
   * @return The link.
   */
  List<Link> getLinks(String rel);
}
