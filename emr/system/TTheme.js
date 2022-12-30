/**
 * 样式和主题单元
 *
 */

export class TTheme {
    constructor(emr) {
        /* 编辑器核心对象 */
        this.emr = emr
        /* 图像加载事件 */
        this.onImageLoad = null;
    }
}