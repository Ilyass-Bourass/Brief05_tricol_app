<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tricol API - Gestion Fournisseurs</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .container {
            background: white;
            border-radius: 15px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            max-width: 900px;
            width: 100%;
            padding: 40px;
        }
        h1 {
            color: #667eea;
            margin-bottom: 10px;
            font-size: 2.5em;
        }
        .subtitle {
            color: #666;
            margin-bottom: 30px;
            font-size: 1.1em;
        }
        .status {
            background: #d4edda;
            border-left: 4px solid #28a745;
            padding: 15px;
            margin-bottom: 30px;
            border-radius: 5px;
        }
        .status strong { color: #28a745; }
        .section {
            margin-bottom: 30px;
        }
        .section h2 {
            color: #333;
            margin-bottom: 15px;
            font-size: 1.5em;
            border-bottom: 2px solid #667eea;
            padding-bottom: 10px;
        }
        .endpoint {
            background: #f8f9fa;
            border-left: 4px solid #667eea;
            padding: 15px;
            margin-bottom: 15px;
            border-radius: 5px;
        }
        .endpoint .method {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 5px;
            font-weight: bold;
            margin-right: 10px;
            color: white;
            font-size: 0.9em;
        }
        .method.get { background: #28a745; }
        .method.post { background: #007bff; }
        .method.put { background: #ffc107; color: #333; }
        .method.delete { background: #dc3545; }
        .url {
            font-family: 'Courier New', monospace;
            color: #495057;
            font-size: 0.95em;
        }
        .description {
            color: #666;
            margin-top: 8px;
            font-size: 0.9em;
        }
        .info-box {
            background: #e7f3ff;
            border-left: 4px solid #2196F3;
            padding: 15px;
            margin-top: 20px;
            border-radius: 5px;
        }
        .info-box strong { color: #2196F3; }
        code {
            background: #f4f4f4;
            padding: 2px 6px;
            border-radius: 3px;
            font-family: 'Courier New', monospace;
            color: #c7254e;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🚀 Tricol API</h1>
        <p class="subtitle">API REST - Gestion des Fournisseurs</p>

        <div class="status">
            <strong>✅ Statut:</strong> L'API est opérationnelle et prête à l'emploi
        </div>

        <div class="section">
            <h2>📋 Endpoints Disponibles</h2>

            <div class="endpoint">
                <span class="method get">GET</span>
                <span class="url">/api/fournisseurs</span>
                <div class="description">Récupérer la liste de tous les fournisseurs</div>
            </div>

            <div class="endpoint">
                <span class="method get">GET</span>
                <span class="url">/api/fournisseurs/{id}</span>
                <div class="description">Récupérer un fournisseur par son ID</div>
            </div>

            <div class="endpoint">
                <span class="method get">GET</span>
                <span class="url">/api/fournisseurs/search?email={email}</span>
                <div class="description">Rechercher un fournisseur par email</div>
            </div>

            <div class="endpoint">
                <span class="method post">POST</span>
                <span class="url">/api/fournisseurs</span>
                <div class="description">Créer un nouveau fournisseur (Body JSON requis)</div>
            </div>

            <div class="endpoint">
                <span class="method put">PUT</span>
                <span class="url">/api/fournisseurs/{id}</span>
                <div class="description">Mettre à jour un fournisseur existant (Body JSON requis)</div>
            </div>

            <div class="endpoint">
                <span class="method delete">DELETE</span>
                <span class="url">/api/fournisseurs/{id}</span>
                <div class="description">Supprimer un fournisseur par son ID</div>
            </div>
        </div>

        <div class="section">
            <h2>📦 Exemple de Body JSON (POST/PUT)</h2>
            <pre style="background: #f4f4f4; padding: 15px; border-radius: 5px; overflow-x: auto;"><code>{
  "nom": "Fournisseur Test",
  "email": "test@example.com",
  "telephone": "0612345678",
  "adresse": "123 Rue Test, Casablanca"
}</code></pre>
        </div>

        <div class="info-box">
            <strong>ℹ️ Note:</strong> Cette application est une API REST pure.
            Utilisez <strong>Postman</strong>, <strong>cURL</strong>, ou tout autre client HTTP pour tester les endpoints.
            <br><br>
            <strong>Base URL:</strong> <code>http://localhost:8080/tricol</code>
        </div>
    </div>
</body>
</html>
