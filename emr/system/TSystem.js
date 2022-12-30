/**
 * 系统类
 *
 */

export class TSystem {
    constructor() {
        /* 行分隔 */
        this.lineBreak = "\r\n";
        /* 屏幕dpi */
        this._dpi = null;
        /* 操作系统 */
        this.os = this._detectOS();
    }

    /**
     * 操作系统检测
     *
     * @private
     */
    _detectOS() {

    }
}