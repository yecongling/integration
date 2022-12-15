import React, {useState} from "react";
import {Button, Modal} from "antd";

const Header: React.FC = () => {
    const [createModalVisible, handleModalVisible] = useState<boolean>(false);
    return (
        <div>
            <Button type="primary" onClick={() => handleModalVisible(true)}>点击弹窗</Button>
            <Modal onCancel={() => handleModalVisible(false)} open={createModalVisible} destroyOnClose={true}
                   onOk={() => handleModalVisible(false)} maskClosable={false}>
                这里面是弹窗的文本内容哦
            </Modal>
        </div>

    )
};

export default Header;