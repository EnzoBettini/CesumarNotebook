import axios from 'axios';

// Criar uma instância do Axios com configurações padrão
const axiosInstance = axios.create({
    baseURL: 'http://localhost:8000',
    timeout: 120000, // Aumentando para 2 minutos
    headers: {
        'Content-Type': 'application/json',
    },
});

// Interceptor de requisição
axiosInstance.interceptors.request.use(
    (config) => {
        // Log da requisição
        console.log(`[API Request] ${config.method.toUpperCase()} ${config.url}`, config.data);
        return config;
    },
    (error) => {
        console.error('[API Request Error]', error);
        return Promise.reject(error);
    }
);

// Interceptor de resposta
axiosInstance.interceptors.response.use(
    (response) => {
        // Log da resposta
        console.log(`[API Response] ${response.config.method.toUpperCase()} ${response.config.url}`, response.data);
        return response;
    },
    (error) => {
        console.error('[API Response Error]', {
            message: error.message,
            response: error.response?.data,
            status: error.response?.status,
            code: error.code,
        });

        // Personalizar mensagens de erro
        if (error.code === 'ECONNABORTED' && error.message.includes('timeout')) {
            error.customMessage = 'The request is taking longer than expected. This might be due to the AI processing. Please try again or reduce the complexity of your request.';
        } else if (error.code === 'ECONNREFUSED') {
            error.customMessage = 'Unable to connect to the server. Please make sure the backend is running.';
        } else if (error.response?.status === 422) {
            error.customMessage = 'Invalid input data. Please check your form values.';
        } else if (error.response?.status === 500) {
            error.customMessage = `Server error: ${error.response?.data?.detail?.error || error.response?.data?.detail || 'An unexpected error occurred'}`;
        } else {
            error.customMessage = error.message || 'An unexpected error occurred';
        }

        return Promise.reject(error);
    }
);

export default axiosInstance;
