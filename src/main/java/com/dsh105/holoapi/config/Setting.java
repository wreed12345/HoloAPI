/*
 * This file is part of HoloAPI.
 *
 * HoloAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * HoloAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with HoloAPI.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.holoapi.config;

import com.dsh105.commodus.config.Option;
import com.dsh105.holoapi.HoloAPI;

import java.util.ArrayList;

public class Setting<T> extends Option<T> {

    private ConfigType configType;

    public Setting(ConfigType configType, String path, String... comments) {
        super(HoloAPI.getConfig(configType).config(), path, comments);
        this.configType = configType;
    }

    public Setting(ConfigType configType, String path, T defaultValue, String... comments) {
        super(HoloAPI.getConfig(configType).config(), path, defaultValue, comments);
        this.configType = configType;
    }

    public Setting(String path, T defaultValue, String... comments) {
        this(ConfigType.MAIN, path, defaultValue, comments);
    }

    public T getValue(Object... replacements) {
        return super.getValue(HoloAPI.getSettings(configType), replacements);
    }

    public T getValue(T defaultValue, Object... replacements) {
        return super.getValue(HoloAPI.getSettings(configType), defaultValue, replacements);
    }

    public void setValue(T value, Object... replacements) {
        super.setValue(HoloAPI.getSettings(configType), value, replacements);
    }
}