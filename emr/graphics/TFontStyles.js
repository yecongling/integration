/**
 * 字体样式单元
 */


import {TFontStyle} from "./TFont";

export class TFontStyles {
    constructor() {
        this._value = 0;
        this.onChange = null;
    }

    /**
     * change事件
     *
     * @private
     */
    doChange_() {
        if (this.onChange != null) {
            this.onChange();
        }
    }

    /**
     * 包含值
     *
     * @param val
     */
    has(val) {
        return (this._value & val) === val;
    }

    /**
     * 添加值
     *
     * @param val
     */
    add(val) {
        this._value = this._value | val;
        this.doChange_();
    }

    /**
     * 移除值
     *
     * @param val
     */
    remove(val) {
        this._value = this._value & ~val;
        this.doChange_();
    }

    /**
     * 清空值
     */
    clear() {
        this._value = 0;
        this.doChange_();
    }

    /**
     * 是否加粗
     *
     */
    get bold() {
        return this.has(TFontStyle.Bold);
    }

    /**
     * 是否斜体
     *
     */
    get italic() {
        return this.has(TFontStyle.Italic);
    }

    /**
     * 获取字体样式
     *
     * @returns {number}
     */
    get value() {
        return this._value;
    }

    /**
     * 设置字体样式
     *
     * @param val
     */
    set value(val) {
        if (this._value !== val) {
            this._value = val;
            this.doChange_();
        }
    }
}