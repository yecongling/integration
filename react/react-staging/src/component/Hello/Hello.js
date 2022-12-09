import React, {useState} from "react"
import {Button, Modal} from "antd";
import './hello.css'
/* hello组件 */
export const Hello = () => {
    const [isModalOpen, setIsModalOpen] = useState(false);

    const showModal = () => {
        setIsModalOpen(true)
    }

    const handleOk = () => {
        setIsModalOpen(false);
    }

    const handleCancel = () => {
        setIsModalOpen(false)
    }

    return (
        <>
            <Button type="primary" onClick={showModal}>点击我</Button>
            <Modal title="这是一个弹窗" okText="确认" cancelText="取消" maskClosable={false} open={isModalOpen} onOk={handleOk} onCancel={handleCancel}>
                <p>这是弹窗的内容文本</p>
            </Modal>
        </>
    )
}