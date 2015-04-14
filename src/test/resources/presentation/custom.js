/*
 * Copyright (C) 2014 Ovea (dev@ovea.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
(function(w) {

  var cartridge = {
    name: 'presentation',
    components: []
  };

  var $ = w.testatoo;

  var base = {
    visible: function(el) {
      return el.is(':visible');
    },
    text: function(el) {
      return el.text().trim();
    }
  };

  $.registerCartridge(cartridge);

  cartridge.components.push($.extend({}, base, {
    type: 'Presentation',
    match: function(el) {
      return el.data('role') == 'slides';
    },
    title: function(el) {
      return el.find('h1').text().trim();
    },
    size: function(el) {
      return el.find('section').length;
    },
    author: function(el) {
      return el.find('[data-role=author]').text().trim();
    },
    company: function(el) {
      return el.find('[data-role=company]').text().trim();
    }

  }));

  cartridge.components.push($.extend({}, base, {
    type: 'Conclusion',
    match: function(el) {
      return el.attr('data-type') == 'conclusion';
    }
  }));

  cartridge.components.push($.extend({}, base, {
    type: 'Teaser',
    match: function(el) {
      return el.attr('data-type') == 'teaser';
    }
  }));

  cartridge.components.push($.extend({}, base, {
    type: 'TextMessage',
    match: function(el) {
      return el.attr('data-type') == 'text-message';
    }
  }));
}(window));