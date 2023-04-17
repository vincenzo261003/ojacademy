import React, { ReactNode } from 'react';
import { Navbar } from '../components/shared/Navbar';

const LayoutHoc = (PassedComponent : () => JSX.Element ) => {

    const LayoutPage = () => {
        return (
            <>
                <Navbar />
                <div style={{marginTop:20}}>
                    <PassedComponent />
                </div>
            </>
        );
    }

    return LayoutPage;
}

export {LayoutHoc as LayoutPage}
