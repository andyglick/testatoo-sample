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
    name: 'bootstrap',
    components: []
  };

  var $ = w.testatoo;
  var html5 = $.getCartridge('html5').support;

  $.registerCartridge(cartridge);

  cartridge.components.push($.support([html5.base], {
    type: 'ProgressBar',
    match: function(el) { return el.attr('role') == 'progressbar'; },
    value: function(el) {
      return document.getElementById(el.attr('id')).style.width
    }
  }));

  cartridge.components.push($.support([html5.base], {
    type: 'TabPanel',
    match: function(el) { return el.hasClass('nav-tabs'); },
    size: function(el) {
      return el.find('a').length;
    }
  }));

  cartridge.components.push($.support([html5.base], {
    type: 'Tab',
    match: function(el) { return el.is('a') && el.closest('ul').hasClass('nav-tabs'); },
    title: function(el) {
      return el.text().trim();
    },
    selected: function(el) {
      return el.closest('li').hasClass('active');
    },
    unselected: function(el) {
      return !this.selected(el);
    }
  }));

  cartridge.components.push($.support([html5.base], {
    type: 'Accordion',
    match: function(el) { return el.hasClass('panel-group'); },
    size: function(el) {
      return el.find('.panel-heading a').length;
    }
  }));

  cartridge.components.push($.support([html5.base], {
    type: 'Item',
    match: function(el) { return el.is('a') && el.closest('div').hasClass('panel-heading'); },
    title: function(el) {
      return el.text().trim();
    },
    selected: function(el) {
      return $('#' + el.attr('href').substring(1)).hasClass('in');
    },
    unselected: function(el) {
      return !this.selected(el);
    }
  }));

}(window));