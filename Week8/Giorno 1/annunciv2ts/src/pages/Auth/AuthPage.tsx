import React, { useState } from 'react';
import { LayoutPage } from '../../layout/LayoutHoc';
import { Alert, Button, Container, Grid, TextField } from '@mui/material';
import { doLogin, doSignin } from '../../services/ad.services';
import { useNavigate } from 'react-router-dom';
import { json } from 'stream/consumers';

const AuthPage = () => {

    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const[email,setEmail]=useState<string>("");
    const[telefono,setTelefono]=useState<string>("");

    const nav = useNavigate();
    const [loginFailed, setLoginFailed] = useState<boolean>(false);
    //-----------------------
    const[islogin,setIslogin] = useState<boolean>(true)

    const login = () => {
        doLogin(username, password).then(
            res => {
                if (res.status === "ok" && res.data){
                    sessionStorage.setItem("user", JSON.stringify(res.data))
                    nav("/")
                }else{
                    setLoginFailed(true);
                }
            }
        )
    }

    const signin=()=>{
        doSignin(username, password,telefono,email)
        .then(res=>{
            if(res.status==="ok")
            {
                sessionStorage.setItem("user",JSON.stringify(res.data))
                nav("/")
            }
        })
    }

    return (
        <>
            <Container>
                {islogin ?
                <>
                    <Grid item md={4} xs={12}>
                        <TextField label="Username" id='username' variant='outlined' fullWidth 
                        value={username}
                        onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                            setUsername(event.target.value);
                        }}/>
                    </Grid>
                    <Grid item md={4} xs={12} style={{marginTop: 20}}>
                        <TextField label="Password" id='password' variant='outlined' type='password' fullWidth
                        value={password}
                        onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                            setPassword(event.target.value);
                        }}/>
                    </Grid>

                    <Grid item xs={12} style={{marginTop: 20}}>
                        <Button variant='contained' fullWidth onClick={() => login()}>Login</Button>
                    </Grid>
                    <Grid item xs={12} style={{marginTop: 20}}>
                    </Grid>

                    {(loginFailed) && <Alert severity="error" style={{marginTop: 30}}>Credenziali errate</Alert>}
                    </>
                :
                <>
                <Grid item md={4} xs={12}>
                        <TextField label="Username" id='username' variant='outlined' fullWidth 
                        value={username}
                        onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                            setUsername(event.target.value);
                        }}/>
                    </Grid>
                    <Grid item md={4} xs={12} style={{marginTop: 20}}>
                        <TextField label="Password" id='password' variant='outlined' type='password' fullWidth
                        value={password}
                        onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                            setPassword(event.target.value);
                        }}/>
                    </Grid>
                    <Grid item md={4} xs={12} style={{marginTop: 20}}>
                        <TextField label="Email" id='email' variant='outlined' fullWidth 
                        value={email}
                        onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                            setEmail(event.target.value);
                        }}/>
                    </Grid>
                    <Grid item md={4} xs={12} style={{marginTop: 20}}>
                        <TextField label="Numero Telefono" id='telefono' variant='outlined' fullWidth 
                        value={telefono}
                        onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                            setTelefono(event.target.value);
                        }}/>
                    </Grid>

                    <Grid item xs={12} style={{marginTop: 20}}>
                        <Button variant='contained' fullWidth onClick={() => signin()}>SignIn</Button>
                    </Grid>
                    <Grid item xs={12} style={{marginTop: 20}}>
                    </Grid>
                </>

                
            }
            <h6 style={{cursor:'pointer',textDecoration:'underline'}} onClick={()=>setIslogin(! islogin)}>{islogin? "Non sei registrato? Registrati!" : "Accedi!"} </h6>

            </Container>
        </>
    )
}

const LayoutAuth = LayoutPage(AuthPage);

export default LayoutAuth;