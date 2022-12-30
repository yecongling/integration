/**
 *
 * 定时器组件
 */
import {TComponent} from "./TComponent";

/* 2228 */
export class TInterval extends TComponent {
    constructor(interval = 1000) {
        super();
        /* 处理 */
        this._handle = 0;
        /* 最后执行时间 */
        this._lastExecTime = 0;
        /* 停止状态 */
        this._stoped = true;
        /* 循环 */
        this.loop = false;
        /* 定时器间隔 */
        this._interval = interval;
        /* 执行函数 */
        this.onExecute = null;
    }

    /**
     * 执行
     *
     * @param now
     * @private
     */
    _execute(now) {
        if (this._lastExecTime === 0) {
            this._lastExecTime = now;
        } else {
            if (now - this._lastExecTime >= this._interval) {
                this.doExecute_();

                if (this.loop)
                    this._lastExecTime = now;
                else {
                    this.doStop_();
                    return;
                }
            }
        }

        if (!this._stoped)
            this._handle = window.requestAnimationFrame((e) => this._execute(e));
    }

    /**
     * 停止
     *
     * @private
     */
    doStop_() {
        this._stoped = true;
    }

    /**
     * 执行
     * @private
     */
    doExecute_() {
        if (this.onExecute != null)
            this.onExecute();
    }

    /**
     * 开启定时器
     *
     */
    start() {
        if (this._handle === 0) {
            this._stoped = false;
            this._lastExecTime = 0;
            this._handle = window.requestAnimationFrame((e) => this._execute(e));
        }
    }

    /**
     * 停止定时器
     *
     */
    stop() {
        if (this._handle > 0) {
            window.cancelAnimationFrame(this._handle);
            this.doStop_();
            this._handle = 0;
        }
    }

    /**
     * 定时器可用
     *
     * @returns {boolean}
     */
    get enabled() {
        return !this._stoped;
    }

    /**
     * 设置定时器是否可用
     *
     * @param val
     */
    set enabled(val) {
        if (val) {
            if (this._stoped)
                this.start();
        } else {
            if (!this._stoped)
                this.stop();
        }
    }
}