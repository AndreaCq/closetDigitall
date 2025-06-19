import React, { useState } from "react";
import { crearUsuario } from "../services/clienteService";

const ClienteForm = () => {
  const [cliente, setCliente] = useState({
    nombre: "",
    correo: "",
    password: "",
    estado: true
  });

  const handleChange = (e) => {
    setCliente({ ...cliente, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    crearUsuario(cliente)
      .then((response) => {
        alert("Usuario creado con éxito");
        console.log(response.data);
      })
      .catch((error) => {
        alert("Error al crear usuario");
        console.error(error);
      });
  };

  return (
    <div>
      <h2>Registrar Cliente</h2>
      <form onSubmit={handleSubmit}>
        <label>Nombre:</label>
        <input type="text" name="nombre" value={cliente.nombre} onChange={handleChange} required />
        <br />
        <label>Correo:</label>
        <input type="email" name="correo" value={cliente.correo} onChange={handleChange} required />
        <br />
        <label>Contraseña:</label>
        <input type="password" name="password" value={cliente.password} onChange={handleChange} required />
        <br />
        <button type="submit">Registrar</button>
      </form>
    </div>
  );
};

export default ClienteForm;
