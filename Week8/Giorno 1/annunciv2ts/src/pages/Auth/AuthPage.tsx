import React from 'react';
import { LayoutPage } from '../../layout/LayoutHoc';

const AuthPage = () => {
    return (
        <>
        <h1>Ciao auth page</h1>
        </>
    )
}

const LayoutAuth = LayoutPage(AuthPage);

export default LayoutAuth;