/**
 * 光标控制单元
 *
 */

export class TCaret {
    /* 4555 */
    constructor() {
        this.reset();
    }

    /**
     * 重置光标
     */
    reset() {
        /* 光标控制（用于光标在不同组件中的控制） */
        this.control = null;
    }
}